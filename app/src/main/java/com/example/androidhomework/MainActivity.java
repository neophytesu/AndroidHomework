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
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });
        init();
    }

    public void init() {
        button1 = findViewById(R.id.button);
        button2 = findViewById(R.id.button2);
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