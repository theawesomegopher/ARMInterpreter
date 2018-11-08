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

    private LinearLayout registersLayout;
    private EditText instructionET;
    private InstructionTranslationService translationService;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registersLayout = (LinearLayout)findViewById(R.id.registerLL);
        this.instructionET = (EditText)findViewById(R.id.armInstructionET);
        ARMap.init();
        translationService = new InstructionTranslationServiceImpl();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.updateRegisters();
    }

    public void excuteButtonPressed(View v) {
        String instruction = this.instructionET.getText().toString();
        this.translationService.executeInstruction(this.translationService.parseInstruction(instruction));
        this.updateRegisters();
        this.hideKeyboard(this);
        Toast.makeText(this,"Executed Instruction", Toast.LENGTH_LONG);
    }

    public void registerButtonPressed(View v) {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }

    private void updateRegisters() {
        this.registersLayout.removeAllViews();
        for(Register r : ARMap.registers) {
            TextView registerTV = new TextView(this);
            registerTV.setText(r.getHumanReadableName() + ": " + r.getValue());
            this.registersLayout.addView(registerTV);
        }
    }

    private void hideKeyboard(Activity activity){
        InputMethodManager imm = (InputMethodManager) activity.getSystemService(Activity.INPUT_METHOD_SERVICE);
        if (imm.isActive()){
            imm.toggleSoftInput(InputMethodManager.HIDE_IMPLICIT_ONLY, 0);
        }
    }
}
