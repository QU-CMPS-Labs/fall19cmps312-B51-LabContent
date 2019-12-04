package qa.edu.qu.cmps312.loginandregistration.activities;

import android.content.Intent;
import android.os.Bundle;
import android.text.method.LinkMovementMethod;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import qa.edu.qu.cmps312.loginandregistration.R;
import qa.edu.qu.cmps312.loginandregistration.models.User;
import qa.edu.qu.cmps312.loginandregistration.repos.UserDao;

public class LoginActivity extends AppCompatActivity {
    EditText email,password;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        TextView register = findViewById(R.id.register_link);
        email = findViewById(R.id.email_edt);
        password = findViewById(R.id.password_edt);
        userDao = new UserDao(this);
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
        boolean isCorrectUser = false;
        User user = userDao.getUser(email.getText().toString());
        if (user.getPassword().equals(password.getText().toString())) {
            Intent intent = new Intent(LoginActivity.this,
                    MainActivity.class);
            intent.putExtra("name",user.getFullName());
            startActivity(intent);
        } else {
            Toast.makeText(this, "Sorry, your user name or password is wrong",
                    Toast.LENGTH_SHORT).show();
        }
    }
}

