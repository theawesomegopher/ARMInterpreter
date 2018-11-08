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
        this.instruction = new BinaryValue(instruction);
        this.destination = new BinaryValue(destination);
        this.source1 = new BinaryValue(sourceReg1);
        this.source2 = new BinaryValue(sourceReg2);
    }

    public BinaryValue getInstruction() {
        return instruction;
    }

    public BinaryValue getDestination() {
        return destination;
    }

    public BinaryValue getShifts() {
        return shifts;
    }

    public BinaryValue getSource2() {
        return source2;
    }

    public BinaryValue getSource1() {
        return source1;
    }
}
