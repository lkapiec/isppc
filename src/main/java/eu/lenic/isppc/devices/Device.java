package eu.lenic.isppc.devices;

public enum Device {

    DEVICE_UNKNOWN(0),
    DEVICE_AT89Sxx(1),    // AT89S53/8252
    DEVICE_LOCKED(2);

    private int value;

    private Device(int value)
    {
        this.value = value;
    }

    public int getValue() {
        return value;
    }
}
