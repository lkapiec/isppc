package eu.lenic.isppc.devices;

public enum MemorySize {

    MAX_FLASH_SIZE(17301504),   // AT45CS1282 (16.5MB)
    MAX_EEPROM_SIZE(4096),
    MAX_USERSIG_SIZE(32);

    private int limits;

    MemorySize(int value)
    {
        this.limits = value;
    }
}
