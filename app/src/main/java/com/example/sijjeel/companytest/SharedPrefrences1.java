package com.example.sijjeel.companytest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class SharedPrefrences1 extends AppCompatActivity {


    @BindView(R.id.etmessage)
    EditText etmessage;
    @BindView(R.id.btnsave)
    Button btnsave;
    @BindView(R.id.btnnext)
    Button btnnext;
    @BindView(R.id.btnShow)
    Button btnShow;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_prefrences1);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btnsave)
    public void onViewClicked() {
        String message = etmessage.getText().toString();
        if(!TextUtils.isEmpty(message)) {
            SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
            SharedPreferences.Editor editor = sharedPreferences.edit();
            editor.putString("message", message);
            editor.apply();
            etmessage.setText("");

            Toast.makeText(SharedPrefrences1.this, "Data Saved", Toast.LENGTH_SHORT);
        }else
        {
            Toast.makeText(SharedPrefrences1.this, "Insert Message", Toast.LENGTH_SHORT);
        }

    }

    @OnClick(R.id.btnnext)
    public void onViewClicked1() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.clear().commit();
        Intent gotonext= new Intent(SharedPrefrences1.this, SharedPrefrences2.class);
        startActivity(gotonext);
    }

    @OnClick(R.id.btnShow)
    public void onViewClicked2() {
        SharedPreferences sharedPreferences = getSharedPreferences("Data", Context.MODE_PRIVATE);
        String data= sharedPreferences.getString("message","");
        if(!TextUtils.isEmpty(data)) {
            etmessage.setText(data);
        }else
        {
            Toast.makeText(SharedPrefrences1.this, "Empty", Toast.LENGTH_SHORT);
        }
    }
}
