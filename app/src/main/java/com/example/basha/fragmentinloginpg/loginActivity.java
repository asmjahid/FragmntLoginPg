
package com.example.basha.fragmentinloginpg;
import android.app.Fragment;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.basha.fragmentinloginpg.Fragments.StartFragment;

public class loginActivity extends AppCompatActivity {

    //Declaration EditTexts
    private EditText unameEt;
    private EditText pwdEt;
    private Button signInBt,signUpBt;
    Preference preference;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        unameEt = (EditText) findViewById(R.id.uname);
        pwdEt =(EditText) findViewById(R.id.pwd);
        Button signInBt= (Button) findViewById(R.id.signInBt);
        Button signUpBt= (Button) findViewById(R.id.signUpBt);
        preference=new Preference(loginActivity.this);

        signInBt.setOnClickListener(new View.OnClickListener() {
                                        @Override
                                        public void onClick(View v) {

                                            String name = unameEt.getText().toString();
                                            String password = pwdEt.getText().toString();

                                            //check authentic

                                            if(preference.retrieveUserName().equals(name) && preference.retrieveUserPassword().equals(password)){
                                                Bundle bundle = new Bundle();
                                                bundle.putString("edttext","loginActivity");
                                                //set Fragment class Activities
                                                /*Intent i = new Intent(loginActivity.this, StartFragment.class);
                                                startActivity(i);*/
                                               /* */
                                                /*Fragmentclass fragobj = new Fragmentclass();
                                                fragobj.setArguments(bundle);*/
                                                Toast.makeText(getApplicationContext(),"Logged In Successfully",Toast.LENGTH_LONG).show();
                                                StartFragment fragobj = new StartFragment();
                                                fragobj.setArguments(bundle);
                                              /*  Intent i = new Intent(loginActivity.this, StartFragment.class);
                                                startActivity(i);
*/
                                            }
                                            else{
                                                Toast.makeText(getApplicationContext(),"Try Again.Invailid User Or Password"+preference.retrieveUserName(),Toast.LENGTH_LONG).show();
                                            }

                                        }
                                    }
        );

        signUpBt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i =new Intent(loginActivity.this,Signup.class);
                startActivity(i);
            }
        });
    }




}
