package ekordik.cuw.edu.arminterpreter;

public class InstructionTranslationServiceImpl implements InstructionTranslationService {

    @Override
    public void executeInstruction(Object genInstruction) {
        ArmInstruction instruction = (ArmInstruction)genInstruction;
        if(instruction.getInstruction().getBits().equals(ARMap.decimalTo11BitBinary(ARMap.instructionsMapping[0]))) {
            int sum = this.addNums(instruction.getSource1(), instruction.getSource2());
            int desIndex = ARMap.findRegisterIndexBy5BitNumber(instruction.getDestination().getBits());
            ARMap.registers[desIndex].setValue(this.addNums(instruction.getSource1(), instruction.getSource2()));
        }
    }

    private int addNums(BinaryValue reg1Address, BinaryValue reg2Address) {
        int reg1Index = ARMap.findRegisterIndexBy5BitNumber(reg1Address.getBits());
        int reg2Index = ARMap.findRegisterIndexBy5BitNumber(reg2Address.getBits());
        return ARMap.registers[reg1Index].getValue() + ARMap.registers[reg2Index].getValue();
    }
}

