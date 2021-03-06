package ekordik.cuw.edu.arminterpreter;

import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedHashMap;
import java.util.Map;

public class ARMap {

    public static final int MEMORY_SIZE = 64;

    public static String[] instructions = {"ADD", "SUB"};
    public static int[] instructionsMapping = {1112, 1624};
    public static Register[] registers = new Register[31];
    public static int[] memory = new int[MEMORY_SIZE];
    public static Map<String, String> instructionsSyntaxMap = new LinkedHashMap<>();

    public static void init() {
        for(int i = 0; i < registers.length; i++) {
            String x = "X";
            ARMap.registers[i] = new Register(x + i);
        }
        Arrays.fill(ARMap.memory, 0);

        instructionsSyntaxMap.put("ADD", "ADD DestReg, SrcReg1, SrcReg2");
        instructionsSyntaxMap.put("ADDI", "ADDI DestReg, SrcReg1, Immediate");
        instructionsSyntaxMap.put("SUB", "SUB DestReg, SrcReg1, SrcReg2");
        instructionsSyntaxMap.put("SUBI", "SUBI DestReg, SrcReg1, Immediate");
        instructionsSyntaxMap.put("MOVZ", "MOVZ DestReg, Immediate");
        instructionsSyntaxMap.put("LDUR", "LDUR DestReg, [BaseAddReg, Offset]");
        instructionsSyntaxMap.put("STUR", "STUR SrcReg, [BaseAddReg, Offset]");
    }

    public static String decimalTo11BitBinary(int opCode) {
        return ARMap.decimalToNBinary(opCode, 11);
    }

    public static String decimalTo5BitBinary(int bin) {
        return ARMap.decimalToNBinary(bin, 5);
    }

    static String decimalToNBinary(int binNum, int numBits) {
        String answer = "";
        while (binNum > 0) {
            answer = (binNum % 2) + answer;
            binNum /= 2;
        }

        for(int i = answer.length(); i < numBits; i++) {
            answer = 0 + answer;
        }

        return answer;
    }

    public static int findInstructionIndex(String instruction) {
        for(int i = 0; i < ARMap.instructions.length; i++ ) {
            if (ARMap.instructions[i].equals(instruction)) {
                return i;
            }
        }
        // Did not find a matching instruction. Also is needed to keep the compiler happy
        return -1;
    }

    public static Register findRegisterWithName(String nameOfRegister) {
        for(Register r: ARMap.registers) {
            if(r.getHumanReadableName().equalsIgnoreCase(nameOfRegister)) {
                return r;
            }
        }
        //Not found
        return null;
    }

    public static int findRegisterIndexBy5BitNumber(String regAddress) {
        for(int i = 0; i < ARMap.registers.length; i++) {
            if (ARMap.registers[i].getFiveBitBinaryRegisterNumber().equals(regAddress)) {
                return i;
            }
        }

        // Default we did not find the register
        return -1;
    }
}
