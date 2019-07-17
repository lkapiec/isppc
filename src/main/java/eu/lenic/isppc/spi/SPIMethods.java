package eu.lenic.isppc.spi;

import eu.lenic.isppc.Delays;
import eu.lenic.isppc.ProcType;
import eu.lenic.isppc.pins.Pins;
import eu.lenic.isppc.pins.PinsIO;

public class SPIMethods extends Pins implements IProtocols  {

    ProcType procType;

    PinsIO pinsIO = new Pins();

    public SPIMethods(ProcType procType)
    {
        this.procType = procType;
    }

    public void WaitClock(int lenght)
    {
        Delays.WaitNS(1);
        Delays.WaitNS(1);
    }

    @Override
    public byte writeReadByte(byte value) {

        int result = 0;

        for(int y = 0; y < 8; y++)
        {
            if((128 & value) == 128)
            {
                pinsIO.Send1();
            } else
            {
                pinsIO.Send0();
            }

            if(this.procType == ProcType.PROC_TYPE_AVR)
                WaitClock(2);
            else
                WaitClock(1);

            pinsIO.clkHi();

            if(this.procType == ProcType.PROC_TYPE_AVR) {
                WaitClock(4);
            }
            else {
                WaitClock(1);
            }

            result = result << 1;

            if(pinsIO.readBit())
                result = result | 1;

            WaitClock(1);

            pinsIO.clkLo();

            WaitClock(1);

            //value = (byte) value << 1;
        }

        return (byte) result;
    }

    @Override
    public void writeByte(byte value) {
        writeReadByte(value);
    }

    @Override
    public byte readByte() {
        return 0;
    }

    @Override
    public void writeBytes(byte[] buffer, int lenght) {
    }

    @Override
    public byte[] readBytes(int lenght) {
        return new byte[0];
    }

    @Override
    public byte[] writeReadBytes(byte[] buffer, int lenght) {
        return new byte[0];
    }

    @Override
    public void sync() {
        //Empty set
    } // complete
}
