package com.example.androidhomework;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class supuser extends AppCompatActivity implements View.OnClickListener {
    private Button button1,button2,button3;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.supuser);
        init();
    }
    public void init() {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button3 = findViewById(R.id.button3);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
        button3.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //普通用户
        if (id == button1.getId()) {
            Intent pri = new Intent(supuser.this, sup_knowledge.class);//
            startActivity(pri);
            //超级用户
        } else if(id == button2.getId()){
            Intent sup = new Intent(supuser.this,sup_question.class );//
            startActivity(sup);
        }else if(id==button3.getId()){
            Intent main = new Intent(supuser.this, MainActivity.class);//
            startActivity(main);
        }
    }
}
