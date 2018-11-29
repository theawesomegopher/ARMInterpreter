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
    private InstructionTranslationService translationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.instructionET = (EditText)findViewById(R.id.armInstructionET);
        ARMap.init();
        translationService = new DecimalInstructionTranslationServiceImpl();
    }

    public void excuteButtonPressed(View v) {
        String instruction = this.instructionET.getText().toString();
        this.translationService.executeInstruction(new Instruction(instruction));
        this.hideKeyboard(this);
        Toast.makeText(this,"Executed Instruction", Toast.LENGTH_SHORT).show();
    }

    public void registerButtonPressed(View v) {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    public void memoryButtonPressed(View v) {
        Intent i = new Intent(this, MemoryScreen.class);
        this.startActivity(i);
    }

    private void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()){
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }
}
