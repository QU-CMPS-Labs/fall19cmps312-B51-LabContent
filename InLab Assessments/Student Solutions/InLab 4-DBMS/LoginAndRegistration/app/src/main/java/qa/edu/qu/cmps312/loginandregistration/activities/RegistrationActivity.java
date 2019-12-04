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

public class RegistrationActivity extends AppCompatActivity {
    EditText name,email,password;
    UserDao userDao;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_registeration);
        name = findViewById(R.id.fullname_edt);
        email = findViewById(R.id.email_edt);
        password = findViewById(R.id.password_edt);
        userDao = new UserDao(this);
        //todo add the user information to the database

        TextView login = findViewById(R.id.login_lnk);
        login.setMovementMethod(LinkMovementMethod.getInstance());
        login.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(RegistrationActivity.this,
                        LoginActivity.class);
                startActivity(intent);
            }
        });
    }

    public void register(View view) {
        User user = new User(name.getText().toString(),email.getText().toString(),password.getText().toString());
        userDao.addUser(user);
        Toast.makeText(RegistrationActivity.this, ""+userDao.getUser(user.getEmail()), Toast.LENGTH_SHORT).show();


    }
}
