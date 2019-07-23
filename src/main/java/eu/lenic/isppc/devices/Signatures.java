package eu.lenic.isppc.devices;

public class Signatures {
    private String name;
    private ProcType procType;
    private byte[] threeByteSignature;
    private int fsize;
    private int esize;
    private int usigsize;
    private int fpage;
    private int fpagesize;
    private int epage;
    private int epagesize;
    private int osccal;
    private Algo algo;
    private Algo algo_erase;
    private Algo algo_lb;
    private Algo algo_busy;
    private int prog_time;
    private String[] lockbits;
    private String[] fusebitslo;
    private String[] fusebitshi;
    private String[] fusebitsext;

    public Signatures(final Builder builder) {
        this.name = builder.name;
        this.procType = builder.procType;
        this.threeByteSignature = builder.threeByteSignature;
        this.fsize = builder.fsize;
        this.esize = builder.esize;
        this.usigsize = builder.usigsize;
        this.fpage = builder.fpage;
        this.fpagesize = builder.fpagesize;
        this.epage = builder.epage;
        this.epagesize = builder.epagesize;
        this.osccal = builder.osccal;
        this.algo = builder.algo;
        this.algo_erase = builder.algo_erase;
        this.algo_lb = builder.algo_lb;
        this.algo_busy = builder.algo_busy;
        this.prog_time = builder.prog_time;
        this.lockbits = builder.lockBits;
        this.fusebitslo = builder.fusebitslo;
        this.fusebitshi = builder.fusebitshi;
        this.fusebitsext = builder.fusebitsext;
    }

    public String getName() {
        return this.name;
    }

    public ProcType getProcType() {
        return this.procType;
    }

    public byte[] getThreeByteSignature() {
        return this.threeByteSignature;
    }

    public int getFsize() {
        return this.fsize;
    }

    public byte[] getSignatures() {
        return threeByteSignature;
    }

    /* */
    public Algo getAlgo() {
        return this.algo;
    }

    public static class Builder {
        private String name = "";
        private ProcType procType = ProcType.PROC_TYPE_NONE;
        private byte[] threeByteSignature = new byte[]{(byte) 0xff, (byte) 0xff, (byte) 0xff};
        private int fsize = 0;
        private int esize = 0;
        private int usigsize = 0;
        private int fpage = 0;
        private int fpagesize = 0;
        private int epage = 0;
        private int epagesize = 0;
        private int osccal = 0;
        private Algo algo = Algo.ALGO_NONE;
        private Algo algo_erase = Algo.ALGO_NONE;
        private Algo algo_lb = Algo.ALGO_NONE;
        private Algo algo_busy = Algo.ALGO_NONE;
        private int prog_time = 0;
        private String[] lockBits = new String[8];
        private String[] fusebitslo = new String[8];
        private String[] fusebitshi = new String[8];
        private String[] fusebitsext = new String[8];

        public Builder setSignature(byte[] threeByteSignature) {
            this.threeByteSignature = threeByteSignature;
            return this;
        }

        public Builder setName(String name) {
            this.name = name;
            return this;
        }

        public Builder setProcType(ProcType procType) {
            this.procType = procType;
            return this;
        }

        public Builder setFSize(int size) {
            this.fsize = size;
            return this;
        }

        public Builder setESize(int size) {
            this.esize = size;
            return this;
        }

        public Builder setUSigSize(int size) {
            this.usigsize = size;
            return this;
        }

        public Builder setFPage(int size) {
            this.fpage = size;
            return this;
        }

        public Builder setFPagesize(int size) {
            this.fpagesize = size;
            return this;
        }

        public Builder setEPage(int size) {
            this.epage = size;
            return this;
        }

        public Builder setEPagesize(int size) {
            this.epagesize = size;
            return this;
        }

        public Builder setOscCal(int value) {
            this.osccal = value;
            return this;
        }

        public Builder setAlgo(Algo algo) {
            this.algo = algo;
            return this;
        }

        public Builder setAlgoErase(Algo algo) {
            this.algo_erase = algo;
            return this;
        }

        public Builder setAlgoLB(Algo algo) {
            this.algo_lb = algo;
            return this;
        }

        public Builder setAlgoBusy(Algo algo) {
            this.algo_busy = algo;
            return this;
        }

        public Builder setProgTime(int time) {
            this.prog_time = time;
            return this;
        }

        public Builder setLockBits(String lockBits[]) {
            this.lockBits = lockBits;
            return this;
        }

        public Builder setFuseBitsLo(String fusebitslo[]) {
            this.fusebitslo = fusebitslo;
            return this;
        }

        public Builder setFuseBitsHi(String fusebitshi[]) {
            this.fusebitshi = fusebitshi;
            return this;
        }

        public Builder setFuseBitsExt(String fusebitsext[]) {
            this.fusebitsext = fusebitsext;
            return this;
        }

        public Signatures build() {
            return new Signatures(this);
        }
    }


    //https://stackoverflow.com/questions/9655181/how-to-convert-a-byte-array-to-a-hex-string-in-java
    private static final char[] HEX_ARRAY = "0123456789ABCDEF".toCharArray();
    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    @Override
    public String toString() {
        return "" + this.name + " (0x" + bytesToHex(this.threeByteSignature) +") ";
    }
}



