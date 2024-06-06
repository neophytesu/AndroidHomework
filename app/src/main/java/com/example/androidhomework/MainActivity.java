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

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    //普通用户
    Button button1;
    //超级用户
    Button button2;

    @Override

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }

    public void init() {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
        button1.setOnClickListener(this);
        button2.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        //普通用户
        if (id == button1.getId()) {
            Intent pri = new Intent(this, priuser.class);
            startActivity(pri);
            //超级用户
        } else {
            Intent sup = new Intent(this, supuser.class);
            startActivity(sup);
        }
    }
}