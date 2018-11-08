package ekordik.cuw.edu.arminterpreter;

import java.util.Arrays;

public class BinaryValue {
    private int numBits;
    private byte[] theBits;
    private String bits;

    public BinaryValue(int numBits) {
        this.numBits = numBits;
        this.theBits = new byte[numBits];
        Arrays.fill(theBits, (byte)0);
    }

    public BinaryValue(String bin) {
        this(bin.length());
        this.bits = bin;
        for(int i = 0; i < this.theBits.length; i++) {
            theBits[i] = bin.charAt(i) == '0' ? (byte)0 : (byte)1;
        }
    }

    public int getNumBits() {
        return numBits;
    }

    public byte[] getTheBits() {
        return theBits;
    }

    public String getBits() {
        return bits;
    }
}
