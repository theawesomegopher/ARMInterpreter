package ekordik.cuw.edu.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout registersLayout;
    private EditText instructionET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registersLayout = (LinearLayout)findViewById(R.id.registerLL);
        this.instructionET = (EditText)findViewById(R.id.armInstructionET);
        ARMap.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registersLayout.removeAllViews();
        for(Register r : ARMap.registers) {
            TextView registerTV = new TextView(this);
            registerTV.setText(r.getHumanReadableName() + ": " + r.getValue());
            this.registersLayout.addView(registerTV);
        }
    }

    public void excuteButtonPressed(View v) {
        String instruction = this.instructionET.getText().toString();
        String[] parts = instruction.split(" ,");
        // Read the instruction from the instructionET and appropriately execute it.
        // e.g. if instructionET contained: ADD X0, X1, X2 -> X0 = sum of X1 and X2
        // Only needs to work for ADD right now
    }

    public void registerButtonPressed(View v) {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }
}
