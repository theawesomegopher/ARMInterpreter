package ekordik.cuw.edu.arminterpreter;

import android.app.Activity;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private EditText instructionET;
    private String instructions;
    private InstructionTranslationService translationService;
    private final String INSTRUCTION_EXTRA = "instruction";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.instructionET = (EditText)findViewById(R.id.armInstructionET);
        ARMap.init();
        translationService = new DecimalInstructionTranslationServiceImpl();

        if(this.getIntent().getStringExtra(this.INSTRUCTION_EXTRA) != null) {
            String instruction = this.instructions;
            String extra = this.getIntent().getStringExtra(this.INSTRUCTION_EXTRA);
            instruction = "\n" + extra;
            this.instructionET.append(instruction);
            this.getIntent().removeExtra(this.INSTRUCTION_EXTRA);
        }
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if(data.getStringExtra(this.INSTRUCTION_EXTRA) != null) {
            String instruction = data.getStringExtra(this.INSTRUCTION_EXTRA);
            this.instructionET.append("\n" + instruction);
            data.removeExtra(this.INSTRUCTION_EXTRA);
        }
    }

    public void excuteButtonPressed(View v) {
        this.hideKeyboard(this);
        String instructions = this.instructionET.getText().toString();
        String lines[] = instructions.split("\n");
        for(String line : lines) {
            if(line.length() > 0) {
                this.translationService.executeInstruction(new Instruction(line.trim()));
            }
        }
        Toast.makeText(this,"Executed Instructions", Toast.LENGTH_SHORT).show();
    }

    public void registerButtonPressed(View v) {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void memoryButtonPressed(View v) {
        Intent i = new Intent(this, MemoryScreen.class);
        this.startActivity(i);
    }

    public void addInstructionPressed(View v) {
        this.instructions = this.instructionET.getText().toString();
        Intent i = new Intent(this, InstructionPickerActivity.class);
        this.startActivityForResult(i, 0);
    }

    public void clearPressed(View v) {
        this.instructionET.setText("");
    }

    public void removeLastPressed(View v) {
        String insturctions = this.instructionET.getText().toString();
        if(insturctions.length() != 0) {
            if(insturctions.charAt(insturctions.length()-1) == '\n') {
                insturctions = insturctions.substring(0, insturctions.length()-1);
            }
            int lastIndex = insturctions.lastIndexOf('\n');
            if(lastIndex < 0) {
                this.instructionET.setText("");
            } else {
                insturctions= insturctions.substring(0, lastIndex);
                this.instructionET.setText(insturctions);
            }

        }
    }

    private void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()){
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }
}
