package ekordik.cuw.edu.arminterpreter;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private LinearLayout registersLayout;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        this.registersLayout = (LinearLayout)findViewById(R.id.registerLL);
        ARMap.init();
    }

    @Override
    protected void onResume() {
        super.onResume();
        this.registersLayout.removeAllViews();
        ARMap.registerValues.forEach((k, v) -> {
            String value = v.isEmpty() ? "null" : v;
            TextView registerTV = new TextView(this);
            registerTV.setText(k + ": " + value);
            this.registersLayout.addView(registerTV);
        });
    }

    public void registerButtonPressed(View v) {
        Intent i = new Intent(this, RegisterScreen.class);
        this.startActivity(i);
    }
}
