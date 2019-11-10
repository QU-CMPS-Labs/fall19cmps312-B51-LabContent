package qa.edu.qu.cmps312.loginandregistration;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView register = findViewById(R.id.register_link);
        register.setMovementMethod(LinkMovementMethod.getInstance());
        register.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(LoginActivity.this,
                        RegistrationActivity.class);
                startActivity(intent);
            }
        });
    }

    public void loginUser(View view) {

        //Todo read the entered user information in the login
        // and check if this user exists or not in the database
        // if they exit log them in otherwise do not log them in
        boolean isCorrectUser = true;
        if (isCorrectUser) {
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            startActivity(intent);
        } else {
            Toast.makeText(this, "Sorry, your user name or password is wrong",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

