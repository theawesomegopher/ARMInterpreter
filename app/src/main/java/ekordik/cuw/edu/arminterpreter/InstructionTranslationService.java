package ekordik.cuw.edu.arminterpreter;

public interface InstructionTranslationService {

    public ArmInstruction parseInstruction(String instruction);

    public void executeInstruction(ArmInstruction instruction);
}
