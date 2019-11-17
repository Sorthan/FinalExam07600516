package su.ac.th.finalexam07600516;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import su.ac.th.finalexam07600516.UserDB.USER;
import su.ac.th.finalexam07600516.UserDB.USERRepository;

public class RegisterActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        onCreateUser();
    }

    public void onCreateUser(){
        Button registerSavebutton = findViewById(R.id.register_button);
        registerSavebutton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                TextView Fullname = findViewById(R.id.full_name_edit_text);
                TextView Username = findViewById(R.id.username_edit_text);
                TextView Password = findViewById(R.id.password_edit_text);

                String full_name = Fullname.getText().toString();
                String username = Username.getText().toString();
                String password = Password.getText().toString();

                if(full_name.length() == 0 || username.length() == 0 || password.length() == 0){
                    Toast.makeText(RegisterActivity.this,"All fields are required",Toast.LENGTH_LONG).show();
                }
                else{
                    USER NewUser = new USER(full_name,username,password);
                    InsertUser(NewUser);
                    Toast.makeText(RegisterActivity.this,"Register successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(RegisterActivity.this,LoginActivity.class);
                    startActivity(intent);
                }
            }
        });

    }

    private void InsertUser(USER user){
        USERRepository checkRegister = new USERRepository(RegisterActivity.this);
        checkRegister.insertUser(user, new USERRepository.InsertCallback() {
            @Override
            public void onInsertSuccess() {
                finish();
            }
        });
    }
}

