package eu.lenic.isppc;

public enum ProcType {

    PROC_TYPE_AVR,     // AT90, ATmega, ATtiny
    PROC_TYPE_NEW51,     // AT89[L]S51/52
    PROC_TYPE_OLD51,     // AT89S53/8252
    PROC_TYPE_S8253,     // AT89S8253
    PROC_TYPE_S2051,     // AT89S2051/4051
    PROC_TYPE_DATAFLASH, // AT25/26/45DB
    PROC_TYPE_SERIALFLASH, // AT25F
    PROC_TYPE_I2C_BUS   // I2C memories
}
