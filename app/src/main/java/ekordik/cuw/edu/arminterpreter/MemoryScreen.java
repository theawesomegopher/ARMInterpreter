package ekordik.cuw.edu.arminterpreter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import org.w3c.dom.Text;

public class MemoryScreen extends AppCompatActivity {

    private ViewGroup memoryVG;
    private EditText[] memoryET;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_memory_screen);
        this.memoryVG = (ViewGroup)this.findViewById(R.id.llMemory);
        EditText tempET;
        TextView indexTV;
        LinearLayout horizontalVG;

        memoryET = new EditText[ARMap.MEMORY_SIZE];
        for(int i = 0; i < ARMap.MEMORY_SIZE; i++) {
            tempET = new EditText(this);
            tempET.setText("" + ARMap.memory[i]);
            tempET.setInputType(InputType.TYPE_CLASS_NUMBER | InputType.TYPE_NUMBER_FLAG_SIGNED);

            this.memoryET[i] = tempET;

            indexTV = new TextView(this);
            indexTV.setText(i + ": ");
            horizontalVG = new LinearLayout(this);
            horizontalVG.setOrientation(LinearLayout.HORIZONTAL);
            horizontalVG.addView(indexTV);
            horizontalVG.addView(tempET);
            this.memoryVG.addView(horizontalVG);
        }
    }

    public void onSaveButtonClicked(View v) {
        for(int i = 0; i < ARMap.MEMORY_SIZE; i++) {
            ARMap.memory[i] = Integer.parseInt(memoryET[i].getText().toString());
        }

        Toast.makeText(this, "Saved", Toast.LENGTH_SHORT).show();
        this.finish();
    }

}
