package ekordik.cuw.edu.arminterpreter;

public class ARMap {
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionsMapping = {1112, 1624};
    public static Register[] registers = new Register[31];

    public static void init() {
        for(int i = 0; i < ARMap.registers.length; i++) {
            String x = "X";
            if (i < 10) {
                x += "0";
            }
            ARMap.registers[i] = new Register(x + i);
        }
    }

    public static String decimalTo11BitBinary(int opCode) {
        return ARMap.decimalToNBinary(opCode, 11);
    }

    public static String decimalTo5BitBinary(int bin) {
        return ARMap.decimalToNBinary(bin, 5);
    }

    private static String decimalToNBinary(int binNum, int numBits) {
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


}
