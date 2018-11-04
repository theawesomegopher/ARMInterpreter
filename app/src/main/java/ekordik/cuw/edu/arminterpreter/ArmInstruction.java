package ekordik.cuw.edu.arminterpreter;

public class ArmInstruction {
    private BinaryValue instruction, destination, shifts, source2, source1;

    public ArmInstruction() {
        instruction = new BinaryValue(11);
        destination = new BinaryValue(5);
        shifts = new BinaryValue(6);
        source2 = new BinaryValue(5);
        source1 = new BinaryValue(5);
    }

    public ArmInstruction(String instruction, String destination, String sourceReg1, String sourceReg2) {
        this();

    }
}
