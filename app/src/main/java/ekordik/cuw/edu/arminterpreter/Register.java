package ekordik.cuw.edu.arminterpreter;

public class Register {
    private String humanReadableName;
    private int decimalRegisterNumber;
    private String fiveBitBinaryRegisterNumber;
    private int value;
    private static int bitSize = 32;

    public Register(String humanReadableName) {
        this.humanReadableName = humanReadableName;
        this.decimalRegisterNumber = Integer.parseInt(this.humanReadableName.substring(1));
        this.fiveBitBinaryRegisterNumber = ARMap.decimalTo5BitBinary(this.decimalRegisterNumber);
        this.value = 0;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getHumanReadableName() {
        return humanReadableName;
    }

    public int getDecimalRegisterNumber() {
        return decimalRegisterNumber;
    }

    public String getFiveBitBinaryRegisterNumber() {
        return fiveBitBinaryRegisterNumber;
    }

    public int getValue() {
        return value;
    }

    static String toBinaryString(int value) {
        if(value < 0) {
            String bin = ARMap.decimalToNBinary(value * -1, bitSize);
            String onesComplement = flipBits(bin);
            return addOne(onesComplement);
        } else {
            return ARMap.decimalToNBinary(value, bitSize);
        }
    }

    private static String flipBits(String bin) {
        String answer = "";
        for(int i =0; i < bin.length(); i++ ) {
            answer += bin.charAt(i) == '0' ? '1' : '0';
        }
        return answer;
    }

    private static String addOne(String bin) {
        String answer = "";
        int i;
        for(i = bin.length()-1; i > 0; i--) {
            if(bin.charAt(i) == '0') {
                answer = '1' + answer;
                break;
            } else {
                answer = '0' + answer;
            }
        }

        while ( i > 0) {
            i--;
            answer = bin.charAt(i) + answer;
        }

        return answer;
    }

}
