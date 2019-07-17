package eu.lenic.isppc.isp;

public interface IChip {

    //procedure SerialflashUnprotectAll;
    public void flashUnprotectAll();

    //function SerialflashErase:integer;
    public int flashErase();

    //procedure SerialflashReadFlashPage(adres:integer; dane:pointer);
    public void flashReadPage(int address, byte[] buffer);

    //function SerialflashWriteFlashPage(adres:integer; dane:pointer):integer;
    public int flashWritePage(int address, byte[] buffer);

    //procedure SerialflashReadSign(s:pointer);
    public void flashReadSign(byte[] buffer);

    //function DataflashReadStatus:byte;
    public byte flashReadStatus();
}
