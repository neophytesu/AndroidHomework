package com.example.androidhomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidhomework.pri.PriUser;
import com.example.androidhomework.sup.SupUser;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //普通用户
    Button mainPri;
    //超级用户
    Button mainSup;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        mainPri = findViewById(R.id.mainPri);
        mainSup = findViewById(R.id.mainSup);
        mainPri.setOnClickListener(this);
        mainSup.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //普通用户
        if (id == mainPri.getId()) {
            Intent pri = new Intent(MainActivity.this, PriUser.class);
            startActivity(pri);
            //超级用户
        } else {
            Intent sup = new Intent(MainActivity.this, SupUser.class);
            startActivity(sup);
        }
    }
}