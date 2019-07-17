package eu.lenic.isppc.devices;

public enum Algo {
    ALGO_STD(1,false),
    ALGO_MEGA(2,false),
    ALGO_DATAFLASH(3,false),
    ALGO_SERIALFLASH(4,false),
    ALGO_AT24_EEPROM ( 5,true),

    ALGO_ERASE_STD ( 0,false),
    ALGO_ERASE_TWICE ( 1,false),

    ALGO_LB_NONE ( 0,false),
    ALGO_LB_STD ( 1,false),
    ALGO_LB_TINY ( 2,false),
    ALGO_LB_2323 ( 3,false),
    ALGO_LB_2333 ( 4,false),
    ALGO_LB_MEGA ( 5,false),
    ALGO_LB_89x ( 6,false),
    ALGO_LB_89S51 ( 7,false),
    ALGO_LB_89S8253 ( 8,false),
    ALGO_LB_89S2051 ( 9,false),

    ALGO_BUSY_WAIT ( 1,false),
    ALGO_BUSY_POLL_00FF ( 2,false),
    ALGO_BUSY_POLL_FF ( 3,false),
    ALGO_BUSY_POLL_NMSB ( 4,false),
    ALGO_BUSY_POLL_RDYBSY ( 5,false),
    ALGO_BUSY_DATAFLASH ( 6,false),
    ALGO_BUSY_SERIALFLASH ( 7,false),
    ALGO_BUSY_AT24_EEPROM ( 8,true);

    private final int value;
    private final boolean i2c_support;
    
    private Algo(int value, boolean i2c_support)
    {
        this.value = value;
        this.i2c_support = i2c_support;
    }
}
