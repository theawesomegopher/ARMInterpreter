package ekordik.cuw.edu.arminterpreter;

public class InstructionTranslationServiceImpl implements InstructionTranslationService {

    @Override
    public ArmInstruction parseInstruction(String instruction) {
        String[] parts = instruction.split(" ");
        int instructionIndex = ARMap.findInstructionIndex(parts[0].toUpperCase().trim());
        String opCode = ARMap.decimalTo11BitBinary(ARMap.instructionsMapping[instructionIndex]);
        String reg1 = ARMap.decimalTo5BitBinary(this.parseRegisterName(parts[2]));
        String reg2 = ARMap.decimalTo5BitBinary(this.parseRegisterName(parts[3]));
        String regDes = ARMap.decimalTo5BitBinary(this.parseRegisterName(parts[1]));
        return new ArmInstruction(opCode, regDes, reg1, reg2);
    }

    @Override
    public void executeInstruction(ArmInstruction instruction) {
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

    private int parseRegisterName(String regName) {
        String value;
        if(regName.contains(",")) {
            value = regName.substring(1, regName.indexOf(",")).trim();
        } else {
            value = regName.substring(1).trim();
        }
        return Integer.parseInt(value);
    }
}

