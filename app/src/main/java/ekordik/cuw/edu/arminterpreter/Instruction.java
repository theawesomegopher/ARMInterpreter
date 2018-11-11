package ekordik.cuw.edu.arminterpreter;

import java.util.LinkedList;

public class Instruction {
    private String magicTrick;
    private String destinationName;
    private LinkedList<String> inputNames = new LinkedList<>();

    public Instruction(String instruction) {
        int locationOfFirstSpace = instruction.indexOf(' ');
        this.magicTrick = instruction.substring(0, locationOfFirstSpace);
        instruction = instruction.substring(locationOfFirstSpace).trim();
        String[] parts = instruction.split(",");
        this.destinationName = parts[0].trim();
        this.inputNames.add(parts[1].trim());
        this.inputNames.add(parts[2].trim());
    }

    public String getMagicTrick() {
        return magicTrick;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public LinkedList<String> getInputNames() {
        return inputNames;
    }
}
