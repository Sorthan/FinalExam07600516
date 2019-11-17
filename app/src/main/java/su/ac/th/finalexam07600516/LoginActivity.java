package su.ac.th.finalexam07600516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.util.List;

import su.ac.th.finalexam07600516.UserDB.USER;
import su.ac.th.finalexam07600516.UserDB.USERRepository;
import su.ac.th.finalexam07600516.UserDB.USERDao;

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
                    CheckingLoginDATA(username, password);
                }
            }
        });
    }

    private void CheckingLoginDATA(final String username, final String password){
        USERRepository checkworking = new USERRepository(LoginActivity.this);
        final String[] fullnameEqualUsername = {""};
        checkworking.getUser(new USERRepository.Callback() {
            @Override
            public void onGetLedger(List<USER> userList) {
                int checkEqual = 0;
                for(USER users : userList){
                    if(username.equals(users.username) && password.equals(users.password)){
                        checkEqual = 1;
                        fullnameEqualUsername[0] = users.fullname;
                        break;
                    }
                }
                if(checkEqual == 1){
                    Toast.makeText(LoginActivity.this,"Welcome "+ fullnameEqualUsername[0],Toast.LENGTH_LONG).show();
                }
                else if(checkEqual == 0){
                    Toast.makeText(LoginActivity.this,"Invalid username or password",Toast.LENGTH_LONG).show();
                }
            }
        });
    }
}
