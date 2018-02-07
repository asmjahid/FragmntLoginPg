package com.example.basha.fragmentinloginpg;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by basha on 2/3/2018.
 */

public class Preference {

    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private Context context;

    static final String PREFERENCE_NAME = "aney";
    static final String NAME_KEY="userName";
    static final String EMAIL_KEY="email";
    static final String PASS_KEY="password";

    public Preference(Context context) {
        this.context = context;
        sharedPreferences = context.getSharedPreferences(PREFERENCE_NAME, Context.MODE_PRIVATE);
        editor = sharedPreferences.edit();
    }

    public  void saveUserName(String userName){
        editor.putString(NAME_KEY, userName);
        editor.commit();

    }
    public  void saveUserEmail(String email){
        editor.putString(EMAIL_KEY, email);
        editor.commit();

    }
    public  void saveUserPassword(String password){
        editor.putString(PASS_KEY, password);
        editor.commit();

    }
    public  String retrieveUserName(){

        String name = sharedPreferences.getString(NAME_KEY, "Data Not Found");
        return name;
    }
    public  String retrieveUserEmail(){
        String email = sharedPreferences.getString(EMAIL_KEY, "Email Not Found");
        return email;

    }
    public  String retrieveUserPassword(){
        String password = sharedPreferences.getString(PASS_KEY, "Password Not Found");
        return password;

    }

}
