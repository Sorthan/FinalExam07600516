package su.ac.th.finalexam07600516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        onClickRegister();
        onInputDataLogin();
    }
    public void onClickRegister(){
        Button registerbutton = findViewById(R.id.register_button);
        registerbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(LoginActivity.this,RegisterActivity.class);
                startActivity(intent);
            }
        });
    }

    public void onInputDataLogin(){
        Button loginbutton = findViewById(R.id.login_button);
        loginbutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView Username = findViewById(R.id.username_edit_text);
                TextView Password = findViewById(R.id.password_edit_text);

                String username = Username.getText().toString();
                String password = Password.getText().toString();

                if(username.length() == 0 || password.length() == 0){
                    Toast.makeText(LoginActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                }
                else{

                }
            }
        });
    }
}
