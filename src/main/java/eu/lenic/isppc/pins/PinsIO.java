package eu.lenic.isppc.pins;

public interface PinsIO {

    public void rstOn();
    public void rstOff();
    public void strobeOn();
    public void strobeOff();
    public void chipSelectOn();
    public void chipSelectOff();
    public boolean readRst();

    public void clkHi();
    public void clkLo();
    public void Send0();
    public void Send1();
    public void lenOn();
    public void ledOff();

    public boolean readBit();
    public void pinoutChanged();
}
