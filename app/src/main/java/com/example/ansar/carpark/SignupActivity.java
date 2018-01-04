package com.example.ansar.carpark;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class SignupActivity extends AppCompatActivity {
    private EditText nameView,emailView,passwordView;
    private Button submitButton;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        nameView=(EditText)findViewById(R.id.name);
        emailView=(EditText)findViewById(R.id.email);
        passwordView=(EditText)findViewById(R.id.password);

        submitButton=(Button)findViewById(R.id.submit_button);

        submitButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                submit();
            }
        });

    }
    private void submit()
    {
        if(!(TextUtils.isEmpty(nameView.getText()))&& !(TextUtils.isEmpty(emailView.getText()))&&!(TextUtils.isEmpty(passwordView.getText())))
        {

            String name =nameView.getText().toString();
            String email =emailView.getText().toString();
            String password =passwordView.getText().toString();
            Intent intent= new Intent(this,LoginActivity.class);
            startActivity(intent);
            finish();
        }
        else
        {
            Toast.makeText(this, "fill all fields", Toast.LENGTH_SHORT).show();
        }
    }
}
