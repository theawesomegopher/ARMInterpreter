package ekordik.cuw.edu.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import java.util.LinkedList;
import java.util.List;

public class InstructionPickerActivity extends AppCompatActivity {
    private LinearLayout layout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_picker);
        this.layout = findViewById(R.id.llInstructionBtns);

        ARMap.instructionsSyntaxMap.keySet().stream().forEach(k -> {
            System.out.println(k);
            Button newBtn = new Button(this);
            newBtn.setText(k);
            newBtn.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    onInstructionButtonClicked(v);
                }
            });
            this.layout.addView(newBtn);
        });
    }

    public void onInstructionButtonClicked(View v) {
        Button b = (Button)v;
        String btnText = b.getText().toString();
        String instruction = ARMap.instructionsSyntaxMap.get(btnText);
        Intent i = new Intent(this, MainActivity.class);
        i.putExtra("instruction", instruction);
        this.setResult(RESULT_OK, i);
        this.finish();
    }

}
