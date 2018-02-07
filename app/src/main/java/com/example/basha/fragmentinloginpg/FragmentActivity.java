package com.example.basha.fragmentinloginpg;

import android.app.Fragment;
import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.example.basha.fragmentinloginpg.Fragments.FragmentFour;
import com.example.basha.fragmentinloginpg.Fragments.FragmentOne;
import com.example.basha.fragmentinloginpg.Fragments.FragmentThree;
import com.example.basha.fragmentinloginpg.Fragments.FragmentTwo;
import com.example.basha.fragmentinloginpg.Fragments.StartFragment;

/**
 * Created by basha on 2/3/2018.
 */

public class FragmentActivity extends AppCompatActivity implements View.OnClickListener {

    private Button pgone,pgtwo,pgthree,pgfour,about;
    //3ta cls 3ta rule,key,ke,kivabe holo eder term
    Fragment currentFragment;
    FragmentManager manager;
    FragmentTransaction transaction;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        about = (Button) findViewById(R.id.aboutBt);
/*        pgone = (Button) findViewById(R.id.pgOne);*/
        pgtwo = (Button) findViewById(R.id.pgTwo);
        pgthree = (Button) findViewById(R.id.pgthree);
        pgfour = (Button) findViewById(R.id.pgfour);

        about.setOnClickListener(this);
        pgone.setOnClickListener(this);
        pgtwo.setOnClickListener(this);
        pgthree.setOnClickListener(this);
        pgfour.setOnClickListener(this);

        currentFragment = new StartFragment();


        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.add(R.id.myFragment,currentFragment);
        transaction.commit();


    }
    @Override
    public void onClick(View view) {

        int id = view.getId();

        switch (view.getId()){
            case R.id.aboutBt:
                currentFragment = new FragmentOne();
                break;
            case R.id.pgTwo:
                currentFragment = new FragmentTwo();
                break;
            case R.id.pgthree:
                currentFragment = new FragmentThree();
                break;
            case R.id.pgfour:
                currentFragment = new FragmentFour();
        }
        //4ta case e apply hobe
        changeFragment();


    }

    private void changeFragment() {
        manager = getFragmentManager();
        transaction = manager.beginTransaction();
        transaction.replace(R.id.myFragment,currentFragment);
        transaction.commit();
    }
}
