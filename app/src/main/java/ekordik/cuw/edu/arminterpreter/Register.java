package ekordik.cuw.edu.arminterpreter;

public class Register {
    private String humanReadableName;
    private int decimalRegisterNumber;
    private String fiveBitBinaryRegisterNumber;
    private int value;

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
}
