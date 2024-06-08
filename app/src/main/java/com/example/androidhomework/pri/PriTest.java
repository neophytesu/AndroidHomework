package com.example.androidhomework.pri;

import static android.view.View.INVISIBLE;
import static android.view.View.VISIBLE;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.example.androidhomework.Mysql;
import com.example.androidhomework.Question;
import com.example.androidhomework.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Objects;

public class PriTest extends AppCompatActivity implements View.OnClickListener {
    private Mysql mysql;
    private SQLiteDatabase sqLiteDatabase;
    //从0开始
    private List<Question> questions = new ArrayList<>();
    private Button testQuit;
    private Button testStart;
    private LinearLayout testLayout;
    private TextView testEmpty;
    private TextView testQues;
    private RadioGroup testAnsGroup;
    private Button testAnsA;
    private Button testAnsB;
    private Button testAnsC;
    private Button testAnsD;
    private Button testPre;
    private Button testNext;
    private TextView testSurplus;
    private int index = 1;
    //从1开始
    private Map<Integer, String> selected = new HashMap<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pri_test);
        init();

    }

    public void init() {
        testQuit = findViewById(R.id.testQUit);
        testQuit.setOnClickListener(this);
        testLayout = findViewById(R.id.testLayout);
        mysql = new Mysql(PriTest.this);
        sqLiteDatabase = mysql.getReadableDatabase();
        try (Cursor resltSet = sqLiteDatabase.rawQuery("Select * from qusetions ORDER BY RANDOM() LIMIT 3", null)) {
            while (resltSet.moveToNext()) {
                Question question = new Question();
                question.setQuestion_text(resltSet.getString(resltSet.getColumnIndexOrThrow("question_text")));
                question.setQuestionA(resltSet.getString(resltSet.getColumnIndexOrThrow("questionA")));
                question.setQuestionB(resltSet.getString(resltSet.getColumnIndexOrThrow("questionB")));
                question.setQuestionC(resltSet.getString(resltSet.getColumnIndexOrThrow("questionC")));
                question.setQuestionD(resltSet.getString(resltSet.getColumnIndexOrThrow("questionD")));
                question.setAnswer(resltSet.getString(resltSet.getColumnIndexOrThrow("answer")));
                question.setScore(Integer.parseInt(resltSet.getString(resltSet.getColumnIndexOrThrow("score"))));
                questions.add(question);
            }
        }
        if (questions.isEmpty()) {
            testEmpty = findViewById(R.id.testEmpty);
            testEmpty.setVisibility(VISIBLE);
        } else {
            testSurplus=findViewById(R.id.testSurplus);
            testEmpty=findViewById(R.id.testEmpty);
            testStart = findViewById(R.id.testStart);
            testStart.setVisibility(VISIBLE);
            testQues = findViewById(R.id.testQues);
            testStart.setOnClickListener(this);
            testAnsGroup = findViewById(R.id.testAnsGroup);
            testAnsA = findViewById(R.id.testAnsA);
            testAnsA.setOnClickListener(this);
            testAnsB = findViewById(R.id.testAnsB);
            testAnsB.setOnClickListener(this);
            testAnsC = findViewById(R.id.testAnsC);
            testAnsC.setOnClickListener(this);
            testAnsD = findViewById(R.id.testAnsD);
            testAnsD.setOnClickListener(this);
            testPre = findViewById(R.id.testPre);
            testPre.setOnClickListener(this);
            testNext = findViewById(R.id.testNext);
            testNext.setOnClickListener(this);
            render();
        }
    }

    @Override
    public void onClick(View v) {
        int id = v.getId();
        if (id == testQuit.getId()) {
            Intent pri = new Intent(this, PriUser.class);
            startActivity(pri);
        } else if (id == R.id.testStart) {
            testStart.setVisibility(INVISIBLE);
            testAnsGroup.setVisibility(VISIBLE);
            testQues.setVisibility(VISIBLE);
            testNext.setVisibility(VISIBLE);
        } else if (id == R.id.testPre) {
            record();
            if (index == 2) {
                testPre.setVisibility(INVISIBLE);
            } else if (index == 3) {
                testNext.setText("下一题");
            }
            index--;
            render();
        } else if (id == R.id.testNext) {
            record();
            if (index == 1) {
                testPre.setVisibility(VISIBLE);
                index++;
                render();
            } else if (index == 2) {
                testNext.setText("提交");
                index++;
                render();
            } else {
                submit();
            }

        }
    }

    //记录用户选择的选项
    private void record() {
        int id = testAnsGroup.getCheckedRadioButtonId();
        if (id == R.id.testAnsA) {
            selected.put(index, "A");
        }else if (id == R.id.testAnsB) {
            selected.put(index, "B");
        }else if (id == R.id.testAnsC) {
            selected.put(index, "C");
        }else if (id == R.id.testAnsD) {
            selected.put(index, "D");
        }
    }

    //提交题目
    private void submit() {
        int finalscore=0;
        testAnsGroup.setVisibility(INVISIBLE);
        testNext.setVisibility(INVISIBLE);
        testPre.setVisibility(INVISIBLE);
        testQues.setVisibility(INVISIBLE);
        for (int i = 0; i < 3; i++) {
            if (selected.containsKey(i+1)){
                Question question=questions.get(i);
                finalscore+= Objects.equals(selected.get(i + 1), question.getAnswer()) ?question.getScore():0;
            }
        }
        String s="本次测验成绩:"+ finalscore+"分";
        Log.i("hhh",s);
        testEmpty.setText(s);
        testEmpty.setVisibility(VISIBLE);
    }

    //渲染题目
    private void render() {
        Question question = questions.get(index - 1);
        testQues.setText(question.getQuestion_text());
        testAnsA.setText(question.getQuestionA());
        testAnsB.setText(question.getQuestionB());
        testAnsC.setText(question.getQuestionC());
        testAnsD.setText(question.getQuestionD());
        testAnsGroup.clearCheck();
        if (selected.containsKey(index)){
            String s=selected.get(index);
            if ("A".equals(s)){
                testAnsGroup.check(R.id.testAnsA);
            }else if("B".equals(s)){
                testAnsGroup.check(R.id.testAnsB);
            }else if("C".equals(s)){
                testAnsGroup.check(R.id.testAnsC);
            }else if("D".equals(s)){
                testAnsGroup.check(R.id.testAnsD);
            }
        }
    }
}
