package eu.lenic.isppc.devices;

public interface IProcessors {
    public Signatures findSignature(byte idstring[]);
    public Signatures findName(String name);
}
