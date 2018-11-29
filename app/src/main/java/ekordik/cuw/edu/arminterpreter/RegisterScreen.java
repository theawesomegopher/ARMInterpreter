package ekordik.cuw.edu.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class RegisterScreen extends AppCompatActivity {

    private EditText[] theRegisterETs = new EditText[31];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_screen);

        this.theRegisterETs[0] = (EditText)this.findViewById(R.id.x0Etxt);
        this.theRegisterETs[1] = (EditText)this.findViewById(R.id.x1Etxt);
        this.theRegisterETs[2] = (EditText)this.findViewById(R.id.x2Etxt);
        this.theRegisterETs[3] = (EditText)this.findViewById(R.id.x3Etxt);
        this.theRegisterETs[4] = (EditText)this.findViewById(R.id.x4Etxt);
        this.theRegisterETs[5] = (EditText)this.findViewById(R.id.x5Etxt);
        this.theRegisterETs[6] = (EditText)this.findViewById(R.id.x6Etxt);
        this.theRegisterETs[7] = (EditText)this.findViewById(R.id.x7Etxt);
        this.theRegisterETs[8] = (EditText)this.findViewById(R.id.x8Etxt);
        this.theRegisterETs[9] = (EditText)this.findViewById(R.id.x9Etxt);
        this.theRegisterETs[10] = (EditText)this.findViewById(R.id.x10Etxt);
        this.theRegisterETs[11] = (EditText)this.findViewById(R.id.x11Etxt);
        this.theRegisterETs[12] = (EditText)this.findViewById(R.id.x12Etxt);
        this.theRegisterETs[13] = (EditText)this.findViewById(R.id.x13Etxt);
        this.theRegisterETs[14] = (EditText)this.findViewById(R.id.x14Etxt);
        this.theRegisterETs[15] = (EditText)this.findViewById(R.id.x15Etxt);
        this.theRegisterETs[16] = (EditText)this.findViewById(R.id.x16Etxt);
        this.theRegisterETs[17] = (EditText)this.findViewById(R.id.x17Etxt);
        this.theRegisterETs[18] = (EditText)this.findViewById(R.id.x18Etxt);
        this.theRegisterETs[19] = (EditText)this.findViewById(R.id.x19Etxt);
        this.theRegisterETs[20] = (EditText)this.findViewById(R.id.x20Etxt);
        this.theRegisterETs[21] = (EditText)this.findViewById(R.id.x21Etxt);
        this.theRegisterETs[22] = (EditText)this.findViewById(R.id.x22Etxt);
        this.theRegisterETs[23] = (EditText)this.findViewById(R.id.x23Etxt);
        this.theRegisterETs[24] = (EditText)this.findViewById(R.id.x24Etxt);
        this.theRegisterETs[25] = (EditText)this.findViewById(R.id.x25Etxt);
        this.theRegisterETs[26] = (EditText)this.findViewById(R.id.x26Etxt);
        this.theRegisterETs[27] = (EditText)this.findViewById(R.id.x27Etxt);
        this.theRegisterETs[28] = (EditText)this.findViewById(R.id.x28Etxt);
        this.theRegisterETs[29] = (EditText)this.findViewById(R.id.x29Etxt);
        this.theRegisterETs[30] = (EditText)this.findViewById(R.id.x30Etxt);

        this.fillRegistersWithCurrentValues();
    }

    private void fillRegistersWithCurrentValues() {
        for(int i = 0; i < this.theRegisterETs.length; i++) {
            this.theRegisterETs[i].setText("" + ARMap.registers[i].getValue());
        }
    }

    public void saveButtonPressed(View v) {
        for(int i = 0; i < this.theRegisterETs.length; i++) {
            ARMap.registers[i].setValue(Integer.parseInt(this.theRegisterETs[i].getText().toString()));
        }

        Toast.makeText(this, "Saved...", Toast.LENGTH_SHORT).show();
        finish();
    }

    public void registerNameTFPressed(View v) {
        TextView tv = (TextView)v;
        String name = tv.getText().toString();
        Intent i = new Intent(this, RegisterDetailScreen.class);
        i.putExtra("detailRegisterName", name);
        this.startActivity(i);
    }
}
