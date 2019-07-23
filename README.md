
Why I used byte instrad of char
https://wiki.freepascal.org/Char

byte data = (byte) 0x82;
int x = (int) data;

System.out.println("value1 is " + data + " !");

System.out.printf("value2 0x%x\n", data);
System.out.printf("value3 %d\n", x & 0xff);


