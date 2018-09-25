package com.example.sijjeel.companytest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPrefrences2 extends AppCompatActivity {

    @BindView(R.id.btnback)
    Button btnback;
//This change is don
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrences2);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnback)
    public void onViewClicked() {
        Intent gotoback= new Intent(SharedPrefrences2.this, SharedPrefrences1.class);
        startActivity(gotoback);
    }
}
