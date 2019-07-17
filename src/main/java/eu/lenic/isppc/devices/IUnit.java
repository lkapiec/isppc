package eu.lenic.isppc.devices;


// modul nie zalezny
public interface IUnit {

    public int findSignature(byte s0, byte s1, byte s2);
    public int findName(String name);
}
