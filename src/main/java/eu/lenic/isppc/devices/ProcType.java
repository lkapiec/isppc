package eu.lenic.isppc.devices;

public enum ProcType {
    PROC_TYPE_NONE(0,"PROC_TYPE_NONE"),     // AT90, ATmega, ATtiny
    PROC_TYPE_AVR(1,"PROC_TYPE_AVR"),     // AT90, ATmega, ATtiny
    PROC_TYPE_NEW51 (2,"PROC_TYPE_NEW51"),     // AT89[L]S51/52
    PROC_TYPE_OLD51 (3,"PROC_TYPE_OLD51"),     // AT89S53/8252
    PROC_TYPE_S8253 (4,"PROC_TYPE_S8253"),     // AT89S8253
    PROC_TYPE_S2051 (5,"PROC_TYPE_S2051"),     // AT89S2051/4051
    PROC_TYPE_DATAFLASH (6,"PROC_TYPE_DATAFLASH"), // AT25/26/45DB
    PROC_TYPE_SERIALFLASH (7,"PROC_TYPE_SERIALFLASH"), // AT25F
    PROC_TYPE_I2C_BUS (8,"PROC_TYPE_I2C_BUS");   // I2C memories

    private int value;
    private String label;

    private ProcType(int value, String label)
    {
        this.value = value;
        this.label = label;
    }

    /*protected static ProcType getCodeFromName(String name) {
        for (ProcType item : values())
            if (item.label.equalsIgnoreCase(name))
                return item.value;
                //return item.
            ProcType.valueOf("adfas");
        return ProcType.PROC_TYPE_NONE;
    }*/


    public static ProcType valueOfLabel(String label) {
        for (ProcType e : values()) {
            if (e.label.equals(label)) {
                return e;
            }
        }
        return null;
    }

    /*protected static String getNameFromCode(ProcType code) {
        for (ProcType item: values())
            if (item.value == code)
                return item.label;
        return "?";
    }*/

    /*protected static String getNumberFromCode(ProcType code) {
        for (ProcType item: values())
            if (item.value == code)
                return item.label;
        return "?";
    }*/
}