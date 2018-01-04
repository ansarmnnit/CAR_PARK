package com.example.ansar.carpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class LoginActivity extends AppCompatActivity {

    private EditText emailView,passwordView;
    private Button loginButton,signupButton;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
        emailView=(EditText)findViewById(R.id.email);
        passwordView=(EditText)findViewById(R.id.password);
        loginButton=(Button)findViewById(R.id.login_button);
        signupButton=(Button)findViewById(R.id.signup_button);

        loginButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               login();
            }
        });
        signupButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                signup();
            }
        });
    }
    private  void login()
    {
        if(!(TextUtils.isEmpty(emailView.getText())&&TextUtils.isEmpty(passwordView.getText())))
        {
            String email=emailView.getText().toString();
            String password=passwordView.getText().toString();
            if(email.equals("xyz")&& password.equals("xyz"))
            {
                Intent intent= new Intent(this,LocationListActivity.class);
                startActivity(intent);
            }
            else
            {
                Toast.makeText(this, "account doesn't exists ", Toast.LENGTH_SHORT).show();
            }
        }

    }
    private  void signup()
    {
        Intent intent= new Intent(this,SignupActivity.class);
        startActivity(intent);
    }

}
