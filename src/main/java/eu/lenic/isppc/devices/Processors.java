package eu.lenic.isppc.devices;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Processors implements IProcessors {

    public enum MemorySize {
        MAX_FLASH_SIZE(17301504),   // AT45CS1282 (16.5MB)
        MAX_EEPROM_SIZE(4096),
        MAX_USERSIG_SIZE(32);

        private int limits;

        MemorySize(int value)
        {
            this.limits = value;
        }
    }

    public enum Device {

        DEVICE_UNKNOWN(0),
        DEVICE_AT89Sxx(1),    // AT89S53/8252
        DEVICE_LOCKED(2);

        private int value;

        private Device(int value)
        {
            this.value = value;
        }

        public int getValue() {
            return value;
        }
    }

    private File folder = new File("defs");
    private List<Signatures> unitsList = new ArrayList<Signatures>();

    //https://stackoverflow.com/questions/16646967/java-util-arrays-equals-with-limited-length
    public static boolean equals(byte[] a, byte[] a2, int length) {
        if (a==a2)
            return true;
        if (a==null || a2==null)
            return false;

        for (int i=0; i<length; i++)
            if (a[i] != a2[i])
                return false;
        return true;
    }

    //https://stackoverflow.com/questions/11208479/how-do-i-initialize-a-byte-array-in-java
    public static byte[] hexStringToByteArray(String s) {
        int len = s.length();
        byte[] data = new byte[len / 2];
        for (int i = 0; i < len; i += 2) {
            if(s.charAt(i) == '$') i++;
            data[i / 2] = (byte)
                    ((Character.digit(s.charAt(i), 16) << 4)
                    + Character.digit(s.charAt(i+1), 16));
        }
        return data;
    }

    public Processors()
    {
        Signatures desc;

        // defined as unknow unit
        desc = new Signatures.Builder().build();
        unitsList.add(desc);

        //there's no need to define all valued due bulder d.p. has default values
        desc = new Signatures.Builder()
                .setSignature(new byte[]{ 0x00,0x00,0x00 })
                .setName("AT89S53/8252")
                .setProcType(ProcType.PROC_TYPE_OLD51)
                .setFSize(12288)
                .setESize(2048)
                .setAlgo(Algo.ALGO_STD)
                .setAlgoErase(Algo.ALGO_ERASE_STD)
                .setAlgoLB(Algo.ALGO_LB_89x)
                .setAlgoBusy(Algo.ALGO_BUSY_POLL_NMSB)
                .setProgTime(16)
                .setLockBits(new String[]{"1", "", "", "", "", "LB3", "LB2", "LB1"})
                .build();

        unitsList.add(desc);

        desc = new Signatures.Builder()
                .setSignature(new byte[]{(byte) 0x0, (byte) 0x1, (byte) 0x2})
                .setName("CHIP LOCKED")
                .build();

        unitsList.add(desc);

        listFilesForFolder(unitsList, folder);
        //throw new IllegalArgumentException("age less than zero: " + 4);
    }

    public static void listFilesForFolder(List<Signatures> unitsList, final File folder) {

        String temp = "";

        System.out.println("Loading definition json files from directory: " + folder.getName());

        JSONParser parser = new JSONParser();

        for (final File fileEntry : folder.listFiles()) {
            if (fileEntry.isFile()) {
                temp = fileEntry.getName();
                if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("json")) {

                    //TODO obsługa windows
                    String resourceName = folder.getAbsolutePath() + "/" + temp;
                    System.out.println("Loading... " + resourceName);

                    try {
                        Object obj = parser.parse(new FileReader(resourceName));

                        JSONObject ol = ((JSONObject) obj);
                        String familly  = (String) ((JSONObject) obj).keySet().iterator().next();

                        System.out.println("Familly " + familly + ":");

                        JSONArray o = (JSONArray) (ol).get(familly);

                        JSONObject post_id;
                        Signatures unit;

                        for (int index = 0; index < o.size(); index++) {
                            post_id = (JSONObject) o.get(index);

                            System.out.print(" " +(String) post_id.get("name"));

                            unit = new Signatures.Builder()
                                    .setSignature(hexStringToByteArray(((String) post_id.get("signature"))))
                                    .setName((String) post_id.get("name"))
                                    .setProcType(ProcType.valueOfLabel((String) post_id.get("proctype")))
                                    .setFSize((int) ((long) post_id.get("fsize")))
                                    .setESize((int) ((long) post_id.get("esize")))
                                    .setUSigSize((int) ((long) post_id.get("usigsize")))
                                    .setFPage((int) ((long) post_id.get("fpage")))
                                    .setFPagesize((int) ((long) post_id.get("fpagesize")))
                                    .setEPage((int) ((long) post_id.get("epage")))
                                    .setFPagesize((int) ((long) post_id.get("epagesize")))
                                    .setOscCal((int) ((long) post_id.get("oscal")))
                                    .setAlgo(Algo.valueOfLabel((String) post_id.get("algo")))
                                    .setAlgoErase(Algo.valueOfLabel((String) post_id.get("algo_erase")))
                                    .setAlgoLB(Algo.valueOfLabel((String) post_id.get("algo_lb")))
                                    .setAlgoBusy(Algo.valueOfLabel((String) post_id.get("algo_busy")))
                                    .setProgTime((int) ((long) post_id.get("prog_time")))
                                    .setLockBits(convert(post_id, "lockbits"))
                                    .setFuseBitsLo(convert(post_id, "fusebitslo"))
                                    .setFuseBitsHi(convert(post_id, "fusebitshi"))
                                    .setFuseBitsExt(convert(post_id, "fusebitsext"))
                                    .build();

                            unitsList.add(unit);
                        }
                    } catch (FileNotFoundException e)
                    {
                        System.out.println("Plik nie zostal odnaleziony");
                    } catch (Exception e) {
                        e.printStackTrace();
                    }
                }
            }
        }
        System.out.println();
        System.out.println("All files loaded.");
    }

    private static String[] convert(JSONObject post_id, String field) {
        String lockbtis[] = new String[8];

        JSONArray lbarr = (JSONArray)post_id.get(field);

        for (int indexlb = 0; indexlb < lbarr.size(); indexlb++) {
            lockbtis[indexlb] = (String) lbarr.get(indexlb);
        }

        return lockbtis;
    }

    @Override
    public Signatures findSignature(byte idstring[]) {
        for(int index = 0 ; index < unitsList.size(); index++)
        {
            //if (n != Device.DEVICE_LOCKED) &&(Signatures[n].name = name)
            if(/*(Device.DEVICE_LOCKED.getValue() != index) &&*/ (equals(idstring, unitsList.get(index).getSignatures(), 3)))
            {
                return unitsList.get(index);
            }
        }
        return null;
    }

    @Override
    public Signatures findName(String name) {
        for(int index = 0 ; index < unitsList.size(); index++) {
            if((Device.DEVICE_LOCKED.getValue() != index) &&(unitsList.get(index).getName().equals(name)))
            {
                return unitsList.get(index);
            }
        }
        return null;
    }

    public int size()
    {
        return unitsList.size();
    }
}
