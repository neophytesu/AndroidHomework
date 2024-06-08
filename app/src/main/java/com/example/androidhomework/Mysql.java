package com.example.androidhomework;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Mysql extends SQLiteOpenHelper {
    private static final String DATABASE_NAME = "redknowledge.db";
    private static final int DATABASE_VERSION = 1;

    // 表格名称
    public static final String TABLE_NAME1 = "knowledgepoint";
    public static final String TABLE_NAME2 = "questions";
    public static final String TABLE_NAME3 = "users";

    public Mysql(Context context) {
        super(context, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        // 创建知识点表
        String SQL_CREATE_KNOWLEDGE_TABLE = "CREATE TABLE " + TABLE_NAME1 + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT," +
                "knowledge_text TEXT)";

        // 创建题目表
        String SQL_CREATE_QUESTION_TABLE = "CREATE TABLE " + TABLE_NAME2 + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "question_text TEXT," +
                "questionA VARCHAR(255)," +
                "questionB VARCHAR(255)," +
                "questionC VARCHAR(255)," +
                "questionD VARCHAR(255)," +
                "answer VARCHAR(255)," +
                "score INTEGER)";

        // 创建用户表
        String SQL_CREATE_USER_TABLE = "CREATE TABLE " + TABLE_NAME3 + " (" +
                "id INTEGER PRIMARY KEY AUTOINCREMENT ," +
                "username VARCHAR(255)," +
                "password VARCHAR(255)," +
                "sum_score INTEGER)";

        db.execSQL(SQL_CREATE_KNOWLEDGE_TABLE);
        db.execSQL(SQL_CREATE_QUESTION_TABLE);
        db.execSQL(SQL_CREATE_USER_TABLE);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // 升级数据库时用
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME1);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME2);
        db.execSQL("DROP TABLE IF EXISTS " + TABLE_NAME3);
        onCreate(db);
    }
}
