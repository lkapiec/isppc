package eu.lenic.isppc.spi;

public interface IProtocols {
    //function  WriteReadByte(n:byte):byte;
    public byte writeReadByte(byte value);

    //procedure WriteByte(n:byte);
    public void writeByte(byte value);

    //function  ReadByte:byte;
    public byte readByte();

    //procedure WriteBytes(ptr:pointer; len:integer);
    public void writeBytes(byte buffer[], int length);

    //procedure ReadBytes(ptr:pointer; len:integer);
    public byte[] readBytes(int length);

    //procedure WriteReadBytes(writeptr, readptr:pointer; len:integer);
    public byte[] writeReadBytes(byte buffer[], int length);

    //procedure Sync;
    public void sync();
}
