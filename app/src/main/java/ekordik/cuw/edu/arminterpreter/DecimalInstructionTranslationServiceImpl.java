package ekordik.cuw.edu.arminterpreter;

public class DecimalInstructionTranslationServiceImpl implements InstructionTranslationService {

    @Override
    public void executeInstruction(Instruction instruction) {
        Register destinationRegister = ARMap.findRegisterWithName(instruction.getDestinationName());

        String magicTrick = instruction.getMagicTrick().toUpperCase();
        switch(magicTrick) {
            case "ADD":
                Register input1Register = ARMap.findRegisterWithName(instruction.getInputNames().get(0));
                Register input2Register = ARMap.findRegisterWithName(instruction.getInputNames().get(1));

                destinationRegister.setValue(input1Register.getValue() + input2Register.getValue());
                break;
            case "SUB":
                input1Register = ARMap.findRegisterWithName(instruction.getInputNames().get(0));
                input2Register = ARMap.findRegisterWithName(instruction.getInputNames().get(1));

                // According to the textbook section 2.2 table 2.2.2 this command works:
                // subtract is	SUB X1, X2, X3 which means this in human readable form X1 = X2 - X3
                // So we put into the destination register the result of input 1 minus input 2 where
                // input 1 is the register immediately following the destination register and
                // input 2 is the last register in the line.
                destinationRegister.setValue(input1Register.getValue() - input2Register.getValue());
                break;
            case "ADDI":
                input1Register = ARMap.findRegisterWithName(instruction.getInputNames().get(0));
                Integer immediateValue = Integer.parseInt(instruction.getInputNames().get(1));
                destinationRegister.setValue(input1Register.getValue() - immediateValue);
                break;
            case "SUBI":
                input1Register = ARMap.findRegisterWithName(instruction.getInputNames().get(0));
                immediateValue = Integer.parseInt(instruction.getInputNames().get(1));
                destinationRegister.setValue(input1Register.getValue() + immediateValue);
                break;
            case "LDUR":
                Register baseRegister = ARMap.findRegisterWithName(instruction.getInputNames().get(0).substring(1));
                String offsetString = instruction.getInputNames().get(1);
                int offset = Integer.parseInt(offsetString.substring(0, offsetString.length()-1));
                destinationRegister.setValue(ARMap.memory[baseRegister.getValue() + offset]);
                break;
        }

    }

}
