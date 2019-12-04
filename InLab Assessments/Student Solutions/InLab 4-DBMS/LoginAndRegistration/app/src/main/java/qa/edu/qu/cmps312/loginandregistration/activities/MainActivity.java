package qa.edu.qu.cmps312.loginandregistration.activities;

import android.os.Bundle;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import qa.edu.qu.cmps312.loginandregistration.R;

public class MainActivity extends AppCompatActivity {
    TextView name;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name = findViewById(R.id.textView);
        //todo : show the user information here
        name.setText("Welcome Ms."+getIntent().getStringExtra("name"));
    }
}
