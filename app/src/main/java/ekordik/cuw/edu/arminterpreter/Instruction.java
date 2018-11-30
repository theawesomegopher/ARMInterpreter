package ekordik.cuw.edu.arminterpreter;

import java.util.LinkedList;

public class Instruction {
    private String magicTrick;
    private String[] parameters;

    public Instruction(String instruction) {
        instruction = instruction.trim();
        int locationOfFirstSpace = instruction.indexOf(' ');
        this.magicTrick = instruction.substring(0, locationOfFirstSpace);
        instruction = instruction.substring(locationOfFirstSpace).trim();
        this.parameters = instruction.split(",");
        for(int i = 0; i < this.parameters.length; i++) {
            this.parameters[i] = this.parameters[i].trim();
        }
    }

    public String getMagicTrick() {
        return magicTrick;
    }

    public String[] getParameters() {
        return this.parameters;
    }

}
