package ekordik.cuw.edu.arminterpreter;

import java.util.Map;
import java.util.concurrent.ConcurrentSkipListMap;

public class ARMap {
    private static String[] instructions = {"ADD", "SUB"};
    private static int[] instructionsMapping = {1112, 1624};
    private static String[] registers = new String[32];
    private static String[] registerBinMap = new String[32];
    public static Map<String, String> registerValues = new ConcurrentSkipListMap<>();

    public static void init() {
        for(int i = 0; i < 30; i++) {
            String x = "X";
            if (i < 10) {
                x += "0";
            }
            ARMap.registers[i] = x + i;
            ARMap.registerBinMap[i] = ARMap.decimalTo5BitBinary(i);
        }
        ARMap.registers[31] = "XZR";
        ARMap.registerBinMap[31] = ARMap.decimalTo5BitBinary(0);

        ARMap.registerValues.put("XZR", "0");
    }

    public static String decimalTo11BitBinary(int opCode) {
        return ARMap.decimalToNBinary(opCode, 11);
    }

    private static String decimalTo5BitBinary(int bin) {
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
