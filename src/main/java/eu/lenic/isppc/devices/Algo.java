package eu.lenic.isppc.devices;

public enum Algo {
    ALGO_NONE(0,"ALGO_NONE",false),
    ALGO_STD(1,"ALGO_STD",false),
    ALGO_MEGA(2,"ALGO_MEGA",false),
    ALGO_DATAFLASH(3,"ALGO_DATAFLASH",false),
    ALGO_SERIALFLASH(4,"ALGO_SERIALFLASH",false),
    ALGO_AT24_EEPROM ( 5,"ALGO_AT24_EEPROM",true),

    ALGO_ERASE_STD ( 0,"ALGO_ERASE_STD",false),
    ALGO_ERASE_TWICE ( 1,"ALGO_ERASE_TWICE",false),

    ALGO_LB_NONE ( 0,"ALGO_LB_NONE",false),
    ALGO_LB_STD ( 1,"ALGO_LB_STD",false),
    ALGO_LB_TINY ( 2,"ALGO_LB_TINY",false),
    ALGO_LB_2323 ( 3,"ALGO_LB_2323",false),
    ALGO_LB_2333 ( 4,"ALGO_LB_2333",false),
    ALGO_LB_MEGA ( 5,"ALGO_LB_MEGA",false),
    ALGO_LB_89x ( 6,"ALGO_LB_89x",false),
    ALGO_LB_89S51 ( 7,"ALGO_LB_89S51",false),
    ALGO_LB_89S8253 ( 8,"ALGO_LB_89S8253",false),
    ALGO_LB_89S2051 ( 9,"ALGO_LB_89S2051",false),

    ALGO_BUSY_WAIT ( 1,"ALGO_BUSY_WAIT",false),
    ALGO_BUSY_POLL_00FF ( 2,"ALGO_BUSY_POLL_00FF",false),
    ALGO_BUSY_POLL_FF ( 3,"ALGO_BUSY_POLL_FF",false),
    ALGO_BUSY_POLL_NMSB ( 4,"ALGO_BUSY_POLL_NMSB",false),
    ALGO_BUSY_POLL_RDYBSY ( 5,"ALGO_BUSY_POLL_RDYBSY",false),
    ALGO_BUSY_DATAFLASH ( 6,"ALGO_BUSY_DATAFLASH",false),
    ALGO_BUSY_SERIALFLASH ( 7,"ALGO_BUSY_SERIALFLASH",false),
    ALGO_BUSY_AT24_EEPROM ( 8,"ALGO_BUSY_AT24_EEPROM",true);

    private final int value;
    private final boolean i2c_support;
    private final String label;

    private Algo(int value,  String label,boolean i2c_support)
    {
        this.value = value;
        this.i2c_support = i2c_support;
        this.label = label;
    }

    public static Algo valueOfLabel(String label) {
        for (Algo e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }

    public boolean i2cSupport()
    {
        return this.i2c_support;
    }
}
