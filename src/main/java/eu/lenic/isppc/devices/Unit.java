package eu.lenic.isppc.devices;

import java.io.File;
import java.io.FileReader;
import java.util.Iterator;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.parser.JSONParser;

public class Unit implements IUnit  {

    public File folder = new File("defs");
    private String temp = "";
    int signcount = 2;

    public Unit()
    {
        listFilesForFolder(folder);
    }

    public void listFilesForFolder(final File folder) {
        JSONParser parser = new JSONParser();

        for (final File fileEntry : folder.listFiles()) {

            if (fileEntry.isFile()) {
                temp = fileEntry.getName();
                System.out.println("Loading definition json files");
                if ((temp.substring(temp.lastIndexOf('.') + 1, temp.length()).toLowerCase()).equals("json")) {

                    System.out.println("file " + folder.getAbsolutePath() + "\\" + fileEntry.getName());

                    try {
                        Object obj = parser.parse(new FileReader(fileEntry.getName()));

                        JSONObject jsonObject = (JSONObject) obj;

                        String name = (String) jsonObject.get("Name");
                        String author = (String) jsonObject.get("Author");
                        JSONArray companyList = (JSONArray) jsonObject.get("Company List");

                        System.out.println("Name: " + name);
                        System.out.println("Author: " + author);
                        System.out.println("\nCompany List:");
                        Iterator<String> iterator = companyList.iterator();
                        while (iterator.hasNext()) {
                            System.out.println(iterator.next());
                        }

                        this.signcount ++;

                    } catch (Exception e) {
                        e.printStackTrace();
                    }

                }
            }
        }
    }

    @Override
    public int findSignature(byte s0, byte s1, byte s2) {
        int result = -1;



        return result;
    }

    @Override
    public int findName(String name) {
        int result = -1;

        for(int index = 0 ; index < signcount; index++) {
            //if (n != Device.DEVICE_LOCKED) &&(Signatures[n].name = name)
            //{
                result = index;
                break;
            //}
        }
        return result;
    }
}
