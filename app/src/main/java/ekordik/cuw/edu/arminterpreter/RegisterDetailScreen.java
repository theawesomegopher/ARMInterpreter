package ekordik.cuw.edu.arminterpreter;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class RegisterDetailScreen extends AppCompatActivity {

    private TextView registerNameTv;
    private TextView decimalValueTV;
    private TextView binaryValueTV;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register_detail_screen);
        this.registerNameTv = (TextView)this.findViewById(R.id.registerNameTv);
        this.decimalValueTV = (TextView)this.findViewById(R.id.tvDecimalValue);
        this.binaryValueTV = (TextView)this.findViewById(R.id.tvBinaryValue);
        String registerName = this.getIntent().getStringExtra("detailRegisterName");
        this.registerNameTv.setText(registerName + " Register Detail");
        Register theRegister = ARMap.findRegisterWithName(registerName);
        this.decimalValueTV.setText(theRegister.getValue() + "");
        this.binaryValueTV.setText(Register.toBinaryString(theRegister.getValue()));
    }


}
