package ekordik.cuw.edu.arminterpreter;

import java.util.List;

public class DecimalInstructionTranslationServiceImpl implements InstructionTranslationService {

    @Override
    public void executeInstruction(Instruction instruction) {
        Register destinationRegister = ARMap.findRegisterWithName(instruction.getParameters()[0]);

        String magicTrick = instruction.getMagicTrick().toUpperCase();
        switch(magicTrick) {
            case "ADD":
                Register input1Register = ARMap.findRegisterWithName(instruction.getParameters()[1]);
                Register input2Register = ARMap.findRegisterWithName(instruction.getParameters()[2]);

                destinationRegister.setValue(input1Register.getValue() + input2Register.getValue());
                break;
            case "SUB":
                input1Register = ARMap.findRegisterWithName(instruction.getParameters()[1]);
                input2Register = ARMap.findRegisterWithName(instruction.getParameters()[2]);


                // According to the textbook section 2.2 table 2.2.2 this command works:
                // subtract is	SUB X1, X2, X3 which means this in human readable form X1 = X2 - X3
                // So we put into the destination register the result of input 1 minus input 2 where
                // input 1 is the register immediately following the destination register and
                // input 2 is the last register in the line.
                destinationRegister.setValue(input1Register.getValue() - input2Register.getValue());
                break;
            case "ADDI":
                input1Register = ARMap.findRegisterWithName(instruction.getParameters()[1]);
                Integer immediateValue = Integer.parseInt(instruction.getParameters()[2]);
                destinationRegister.setValue(input1Register.getValue() + immediateValue);
                break;
            case "SUBI":
                input1Register = ARMap.findRegisterWithName(instruction.getParameters()[1]);
                immediateValue = Integer.parseInt(instruction.getParameters()[2]);
                destinationRegister.setValue(input1Register.getValue() - immediateValue);
                break;
            case "LDUR":
                int memoryAddress = getMemoryAddress(instruction.getParameters());
                destinationRegister.setValue(ARMap.memory[memoryAddress]);
                break;
            case "STUR":
                memoryAddress = this.getMemoryAddress(instruction.getParameters());
                ARMap.memory[memoryAddress] = destinationRegister.getValue();
                break;
            case "MOVZ":
                immediateValue = Integer.parseInt(instruction.getParameters()[1]);
                destinationRegister.setValue(immediateValue);
        }

    }

    // Gets the memory address from code set up as [X2, 3] where the first part is the
    // name of a register and the second is an offeset for memory. This function allows for DRY
    private int getMemoryAddress(String[] parameters) {
        Register baseRegister = ARMap.findRegisterWithName(parameters[1].substring(1));
        String offsetString = parameters[2];
        int offset = Integer.parseInt(offsetString.substring(0, offsetString.length()-1));
        return baseRegister.getValue() + offset;
    }
}
