package com.example.mymusic.db;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

import com.example.mymusic.activity.RegisterActivity;

import java.net.ConnectException;

public class DBHelper extends SQLiteOpenHelper {
    public DBHelper(String s, @Nullable Context context, int version)
    {
        super(context,"music.db",null,version);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.e("TAG", "onCreate()" );
        //建表
        String sql = "create table user( _id integer primary key autoincrement, name varchar, age int,phone varchar,email varchar,password varchar,images varchar)";
        db.execSQL(sql);
        //插入一些数据

        //直接sql语句操作数据库表
        db.execSQL("insert into user(name,age,phone,email,password,images) values('YenKoc',25,'18679590623','1070301929@qq.com','123456','1.jpg')");
        db.execSQL("insert into user(name,age,phone,email,password,images) values('Linminhao',23,'15059950623','1070301929@qq.com','123456789','2.jpg')");

    }
    /**
     * 当传入的版本号大于数据库库版本号时调用
     * @param db
     * @param oldVersion
     * @param newVersion
     */
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        Log.e("TAG","DBHelper onUpgrade()");

    }

}
