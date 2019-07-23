
Why I used byte instrad of char
https://wiki.freepascal.org/Char

byte data = (byte) 0x82;
int x = (int) data;

System.out.println("value1 is " + data + " !");

System.out.printf("value2 0x%x\n", data);
System.out.printf("value3 %d\n", x & 0xff);


// do testow dodac

        Processors procesors = new Processors();
        
        Signatures sig0 = procesors.findSignature(new byte[]{ 0x00,0x00,0x00 });
        Signatures sig1 = procesors.findSignature(new byte[]{ 0x00,0x01,0x02 });
        Signatures sig2 = procesors.findSignature(new byte[]{ (byte) 0xFF, (byte) 0xff, (byte) 0xff });
        Signatures sig3 = procesors.findName("");
        Signatures sig4 = procesors.findName("AAAAA");
        Signatures sig5 = procesors.findName("AT89S53/8252");

