package eu.lenic.isppc.app;


import eu.lenic.isppc.devices.Processors;
import eu.lenic.isppc.devices.Signatures;

public class ISPpc extends Gui {

    static String json = "...";


    public static void main(String arg[])
    {

        //Gui gui  = new Gui(arg);
        Processors procesors = new Processors();

        //Signatures sig0 = procesors.findSignature(new byte[]{ 0x00,0x00,0x00 });
        //Signatures sig1 = procesors.findSignature(new byte[]{ 0x00,0x01,0x02 });
        //Signatures sig2 = procesors.findSignature(new byte[]{ (byte) 0xFF, (byte) 0xff, (byte) 0xff });
        //Signatures sig3 = procesors.findName("");
        //Signatures sig4 = procesors.findName("AAAAA");
        //Signatures sig5 = procesors.findName("AT89S53/8252");
        //Signatures sig6 = procesors.findName("A");
        //Signatures sig0 = procesors.findSignature(new byte[]{ 0x11,0x22,0x33 });


        //Signatures sig7 = procesors.findName("AT24C1024");
        Signatures sig8 = procesors.findSignature(new byte[]{ (byte)0xa0,0x24,0x12 });


        System.out.println("Ilosc wszyskich jednostek " + procesors.size());


    }

}
