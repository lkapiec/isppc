package eu.lenic.isppc.isp;

public class SerialFlash implements IChip {
    @Override
    public void flashUnprotectAll() {

    }

    @Override
    public int flashErase() {
        return 0;
    }

    @Override
    public void flashReadPage(int address, byte[] buffer) {

    }

    @Override
    public int flashWritePage(int address, byte[] buffer) {
        return 0;
    }

    @Override
    public void flashReadSign(byte[] buffer) {

    }

    @Override
    public byte flashReadStatus() {
        return 0;
    }
}
