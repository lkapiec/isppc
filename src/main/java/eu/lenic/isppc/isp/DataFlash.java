package eu.lenic.isppc.isp;

import eu.lenic.isppc.spi.SPIMethods;

import javax.xml.crypto.Data;

public class DataFlash implements IChip {
    SPIMethods spiMethods;

    byte devicern = 0;

    public DataFlash(SPIMethods spiMethods)
    {
        this.spiMethods = spiMethods;
    }/* completed */

    public void flashReadDeviceID(Byte b1, Byte b2, Byte b3)
    {
        //ChipselectOn;
        spiMethods.chipSelectOn();

        //WriteByte($9f);
        spiMethods.writeByte((byte) 0x9f);

        //b1:=ReadByte;
        b1 = spiMethods.readByte();

        //b2:=ReadByte;
        b2 = spiMethods.readByte();

        //b3:=ReadByte;
        b3 = spiMethods.readByte();

        //ChipselectOff;
        spiMethods.chipSelectOff();
    }/* completed */

    public void flashWaitForReady()
    {
        //const  t1:Int64 = 0;
        //Tic(t1);
        //repeat until ((DataflashReadStatus and $80) = $80) or (TocMS(t1) > 100);
    }

    @Override
    public void flashUnprotectAll() {
    }

    @Override
    public int flashErase() {

        //var pagesize_big, pages, blocks, blockshift, i:integer;
        //data:array[0..3] of byte;

        //if devicenr < 1 then
        //        Exit;
        //pagesize_big:=(1 shl (Signatures[devicenr].fpage - 1)) + (1 shl (Signatures[devicenr].fpage - 6));
        //pages:=Signatures[devicenr].fsize div pagesize_big;
        //blocks:=pages div 8;
        //blockshift:=Signatures[devicenr].fpage - 5;
        //for i:=0 to blocks - 1 do
         //   begin
        {
            //           ChipselectOn;
            //data[0] := $50;
            //data[1] := Hi(word(i shl blockshift));
            //data[2] := Lo(word(i shl blockshift));
            //data[3] := $00;
            //WriteBytes(@data, 4);
            //Sync;
            //ChipselectOff;
            //DataflashWaitForReady;
        }


        return 0;
    }

    @Override
    public void flashReadPage(int address, byte[] buffer) {
        int pagesize, pagenum;

        //data:array[0..7] of byte;
        byte[] data = new byte[8];

        //if devicenr < 1 then
        //        Exit;
        //pagesize:=Signatures[devicenr].fpagesize;
        pagesize = 1;

        //pagenum:=address div pagesize;
        pagenum = address / pagesize;

        //adres:=pagenum shl Signatures[devicenr].fpage;
        address = pagenum << 0;

        //ChipselectOn;
        spiMethods.chipSelectOn();

        //data[0] := $D2;
        data[0] = (byte) 0xD2;

        //data[1] := (adres shr 16) and $FF;
        data[1] = (byte) ((address >> 16) & 0xFF);

        //data[2] := (adres shr 8) and $FF;
        data[2] = (byte) ((address >> 8) & 0xFF);

        //data[3] := adres and $FF;
        data[3] = (byte) ((address >> 0) & 0xFF);

        //data[4] := $00;
        data[4] = (byte) 0x0;

        //data[5] := $00;
        data[5] = (byte) 0x0;

        //data[6] := $00;
        data[6] = (byte) 0x0;

        //data[7] := $00;
        data[7] = (byte) 0x0;

        //WriteBytes(@data, 8);
        spiMethods.writeBytes(data, data.length);

        //ReadBytes(dane, pagesize);
        spiMethods.writeReadBytes(data, pagesize);

        //ChipselectOff;
        spiMethods.chipSelectOff();
    }

    @Override
    public int flashWritePage(int address, byte[] buffer) {

        int pagesize;
        //data:array[0..3] of byte;
        byte[] data = new byte[4];


        int fpageSize = 0;//Signatures[devicenr].fpagesize;

        //if devicenr < 1 then
        //        Exit;
        //pagesize:=Signatures[devicenr].fpagesize;
        pagesize = 0;
        int fpage = 0;

        //adres:=(adres div pagesize) shl Signatures[devicenr].fpage;
        address = address / pagesize >> fpage;

        //ChipselectOn;
        spiMethods.chipSelectOn();



        //data[0] := $82;
        data[0] = (byte) 0x82;

        //data[1] := (adres shr 16) and $FF;
        data[1] = (byte) ((address >> 16) & 0xFF);

        //data[2] := (adres shr 8) and $FF;
        data[2] = (byte) ((address >> 8) & 0xFF);

        //data[3] := adres and $FF;
        data[3] = (byte) ((address >> 0) & 0xFF);

        //WriteBytes(@data, 4);
        spiMethods.writeBytes(data, data.length);

        //WriteBytes(dane, pagesize); // blad TODO
        spiMethods.writeBytes(buffer, pagesize);

        //Sync;
        spiMethods.sync();

        //ChipselectOff;
        spiMethods.chipSelectOff();

        //DataflashWaitForReady;
        this.flashWaitForReady();

        return 0;
    }

    @Override
    public void flashReadSign(byte[] buffer) {
        byte b;
        //ptr:^byte;
        //const
        //data:array[0..2] of byte = (0, 0, 0);
        //ptr:=s;

        //b:=DataflashReadStatus;
        b = this.flashReadStatus();

        //DataflashReadDeviceID(data[0], data[1], data[2]);
        //this.flashReadDeviceID(1,2,3);

        //if (data[0] <> $ff) and (data[1] <> $ff) and (data[2] <> $ff) then
        //ptr^:=b and $3d   // memory size mask and page size bit
        //else if b <> $ff then
        //ptr^:=b and $3c   // memory size mask only
        //else
        //ptr^:=b;          // $FF and no Manufacturer/Device ID
        //Inc(ptr);
        //ptr^:=data[0];
        //Inc(ptr);
        //ptr^:=data[1];
    }

    @Override
    public byte flashReadStatus() {
        byte result = 0;

        //ChipselectOn;
        spiMethods.chipSelectOn();

        //WriteByte($d7);
        spiMethods.writeByte((byte) 0xd7);

        //Result:=ReadByte;
        result = spiMethods.readByte();

        //ChipselectOff;
        spiMethods.chipSelectOff();
        return result;
    }/* completed */
}
