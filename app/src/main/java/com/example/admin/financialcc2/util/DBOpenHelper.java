package com.example.admin.financialcc2.util;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

/**
 * Created by admin on 2019/4/12.
 */

public class DBOpenHelper extends SQLiteOpenHelper {
    private static String TAG="DBOpenHelper";

    //第一次创建数据库时调用
    private static final int VERSION=1;//规范：常量大写
    //数据库的名称
    private static final String DB_NAME="st.db";
    //数据库的版本号
    public DBOpenHelper(Context context) {
        super(context, DB_NAME, null, VERSION);//参数1上下文
    }
    /**
     * 第一次创建数据库的时候调用
     * @param db
     */

    @Override
    public void onCreate(SQLiteDatabase db) {
        Log.d(TAG, "onCreate() called with: db = [" + db + "]");
        //创建表
        String tb_pwd="create table tb_pwd(password varchar(20))";
        String tb_outaccount="create table tb_outaccount(_id integer primary key autoincrement,\n" +
                "money decimal,time varhcar(10),type varchar(10),mark varchar(200))";
        String tb_inaccount="create table tb_inaccount(_id integer primary key autoincrement,\n" +
                "money decimal,time varhcar(10),type varchar(10),mark varchar(200))";
        String tb_flag="create table tb_flag(_id integer primary key autoincrement,\n" +
                "flag varchar(200),add_date integer)";
        db.execSQL(tb_pwd);
        db.execSQL(tb_outaccount);
        db.execSQL(tb_inaccount);
        db.execSQL(tb_flag);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {

    }
}
