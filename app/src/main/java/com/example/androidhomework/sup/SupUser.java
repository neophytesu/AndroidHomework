package com.example.androidhomework.sup;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidhomework.MainActivity;
import com.example.androidhomework.R;

public class SupUser extends AppCompatActivity implements View.OnClickListener {
    private Button supKnow, supTest, supQuit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.sup_user);
        init();
    }

    public void init() {
        supKnow = findViewById(R.id.supKnow);
        supTest = findViewById(R.id.supTest);
        supQuit = findViewById(R.id.supQuit);
        supKnow.setOnClickListener(this);
        supTest.setOnClickListener(this);
        supQuit.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //知识点
        if (id == supKnow.getId()) {
            Intent pri = new Intent(SupUser.this, SupKnowledge.class);
            startActivity(pri);
            //问题
        } else if (id == supTest.getId()) {
            Intent sup = new Intent(SupUser.this, SupQuestion.class);
            startActivity(sup);
            //退出
        } else if (id == supQuit.getId()) {
            Intent main = new Intent(SupUser.this, MainActivity.class);
            startActivity(main);
        }
    }
}
