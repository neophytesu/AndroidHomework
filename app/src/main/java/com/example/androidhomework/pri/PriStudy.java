package com.example.androidhomework.pri;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;


import com.example.androidhomework.Mysql;
import com.example.androidhomework.R;

import java.util.ArrayList;
import java.util.List;

public class PriStudy extends AppCompatActivity implements View.OnClickListener {

    private List<String> knowledgePoints = new ArrayList<>();
    private int currentIndex = 0;
    private Handler handler = new Handler();
    private Runnable runnable;
    private Mysql mysql;
    private TextView knowledgePointTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pri_study);
        mysql = new Mysql(this);

        init();
    }

    public void init() {
        LinearLayout learningLayout = findViewById(R.id.pri_learn);
        knowledgePointTextView = findViewById(R.id.textView_pri_konwpoint);
        Button nextButton = findViewById(R.id.button_pri_study_next);
        Button backButton = findViewById(R.id.button_pri_study_return);

        selectAll();

        nextButton.setOnClickListener(v -> showNextKnowledgePoint());

        backButton.setOnClickListener(v -> {
            stopAutoScroll();
            Intent intent = new Intent(this, PriUser.class);
            startActivity(intent);
        });

        // 开始自动滚动
        startAutoScroll();
    }

    private void startAutoScroll() {
        runnable = new Runnable() {
            @Override
            public void run() {
                showNextKnowledgePoint();
                handler.postDelayed(this, 5000);
            }
        };
        handler.post(runnable);
    }

    private void showNextKnowledgePoint() {
        if (!knowledgePoints.isEmpty()) {
            currentIndex = (currentIndex + 1) % knowledgePoints.size();
            knowledgePointTextView.setText(knowledgePoints.get(currentIndex));
        } else {
            knowledgePointTextView.setText("没有知识点");

        }
    }

    private void stopAutoScroll() {
        handler.removeCallbacks(runnable);
    }

    private void selectAll() {
        SQLiteDatabase db = mysql.getReadableDatabase();
        String[] col = {"knowledge_text"};
        String tableName = "knowledgepoint";
        Cursor cursor = db.query(tableName, col, null, null, null, null, null);

        if (cursor != null) {
            while (cursor.moveToNext()) {
                knowledgePoints.add(cursor.getString(cursor.getColumnIndexOrThrow("knowledge_text")));
            }
            cursor.close();
        }





        db.close();
    }

    @Override
    public void onClick(View v) {
        // 可以在这里处理其他点击事件
    }

    @Override
    protected void onResume() {
        super.onResume();
    }

    @Override
    protected void onPause() {
        super.onPause();
        stopAutoScroll();
    }
}
