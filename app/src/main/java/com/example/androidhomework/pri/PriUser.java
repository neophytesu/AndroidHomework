package com.example.androidhomework.pri;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidhomework.MainActivity;
import com.example.androidhomework.R;

public class PriUser extends AppCompatActivity implements View.OnClickListener {

    private Button priStudy, priTest, priQuit;
    //超级用户

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.pri_user);
        init();

    }
    public void init() {
        priStudy = findViewById(R.id.priStudy);
        priTest = findViewById(R.id.priTest);
        priQuit = findViewById(R.id.priQuit);
        priStudy.setOnClickListener(this);
        priTest.setOnClickListener(this);
        priQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //学习
        if (id == priStudy.getId()) {
           Intent pri = new Intent(this, PriStudy.class);
            startActivity(pri);
            //测试
        } else if(id == priTest.getId()){
            Intent sup = new Intent(this, PriTest.class );
            startActivity(sup);
            //退出
        }else if(id== priQuit.getId()){
           Intent main = new Intent(this, MainActivity.class);
           startActivity(main);
        }
    }
}