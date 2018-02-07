package com.example.basha.fragmentinloginpg;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class Signup extends AppCompatActivity {

    private EditText unameEt,emailEt,pwdEt;
    private Button regBt;
    Preference preference;
    private  String nameTobeSaved ,emailTobeSaved, passTobeSaved;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        unameEt = (EditText) findViewById(R.id.unameEt);
        emailEt = (EditText) findViewById(R.id.emailEt);
        pwdEt =(EditText) findViewById(R.id.pwdEt);
        Button regBt= (Button) findViewById(R.id.regBt);
        preference=new Preference(Signup.this);

        regBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                nameTobeSaved = unameEt.getText().toString();
                emailTobeSaved = emailEt.getText().toString();
                passTobeSaved  = pwdEt.getText().toString();

                preference.saveUserName(nameTobeSaved);
                preference.saveUserEmail(emailTobeSaved);
                preference.saveUserPassword(passTobeSaved);

                if(preference.retrieveUserEmail()!=""){
                    Toast.makeText(getApplicationContext(),"Password Saved Successfully",Toast.LENGTH_LONG).show();
                    Intent intent = new Intent(Signup.this,loginActivity.class);
                    startActivity(intent);
                }

            }
        });
    }
}
