package com.example.androidhomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

import androidx.annotation.Nullable;

public class Mysql extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "redknowledge.db";
    private static final int DATABASE_VERSION = 1;

    // 表格名称
    public static final String TABLE_NAME1 = "konwledgepoint";
    public static final String TABLE_NAME2 = "qusetions";




    public Mysql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建知识点表
        String SQL_CREATE_KNOWLEDGE_TABLE = "CREATE TABLE " + TABLE_NAME1 + " (" +
                "id" + " varchar(255) PRIMARY KEY," +
                "knowledge_text" + " text)";
        //创建题目表
        String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_NAME2 + " (" +
                "id" + " varchar(255) PRIMARY KEY," +
                "question_text" + " text," +
                "questionA" + " varchar(255)," +
                "questionB" + " varchar(255)," +
                "questionC" + " varchar(255)," +
                "questionD" + " varchar(255)," +
                "answer" + " varchar(255)," +
                "score" + " INTEGER)";
        //创建用户表
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME2 + " (" +
                "id" + " varchar(255) PRIMARY KEY," +
                "username" + " varchar(255)," +
                "password" + " varchar(255)," +
                "sum_score" + " INTEGER)";

        db.execSQL(SQL_CREATE_KNOWLEDGE_TABLE);
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL(SQL_CREATE_USER_TABLE);

    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 升级数据库
        // 暂时不添加新的代码行
    }
}
