package ekordik.cuw.edu.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.LinkedList;
import java.util.List;

public class InstructionPickerActivity extends AppCompatActivity {
    private List<Button> theButtons = new LinkedList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_instruction_picker);
        theButtons.add((Button)findViewById(R.id.btnAdd));
        theButtons.add((Button)findViewById(R.id.btnAddI));
        theButtons.add((Button)findViewById(R.id.btnSub));
        theButtons.add((Button)findViewById(R.id.btnSubI));
        theButtons.add((Button)findViewById(R.id.btnMovz));
        theButtons.add((Button)findViewById(R.id.btnLdur));
        theButtons.add((Button)findViewById(R.id.btnStur));
    }

    public void onInstructionButtonClicked(View v) {
        int pos = this.indexOfButton((Button)v);

    }

    private int indexOfButton(Button b) {
        for(int i = 0; i < theButtons.size(); i++) {
            if(b == this.theButtons.get(i)) {
                return i;
            }
        }
        return -1;
    }
}
