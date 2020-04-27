package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.financialcc2.util.DBOpenHelper;

/**
 * Created by admin on 2019/4/18.
 */

public class terminal_555Activity extends Activity implements View.OnClickListener{
    private EditText editText_page555_1;
    private Button button_page555_1,button_page555_2;
    private DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
    private String password;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page555);
        button_page555_1=(Button)findViewById(R.id.button_page555_1);
        button_page555_2=(Button)findViewById(R.id.button_page555_2);
        button_page555_1.setOnClickListener(this);
        button_page555_2.setOnClickListener(this);
        editText_page555_1=(EditText)findViewById(R.id.editText_page555_1);
        password=editText_page555_1.getText().toString();
        DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
        dbOpenHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_page555_1:
                password=editText_page555_1.getText().toString();
                SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
//                ContentValues 和HashTable类似都是一种存储的机制
//                但是两者最大的区别就在于，contenvalues只能存储基本类型的数据，像string，int之类的，不能存储对象这种东西，而HashTable却可以存储对象。
                ContentValues contentValues=new ContentValues();
                contentValues.put("password",password);
                db.update("tb_pwd",contentValues,"password",null);
                Toast.makeText(this,"操作成功",Toast.LENGTH_SHORT).show();
                finish();
                break;
            case R.id.button_page555_2:
                finish();
                break;
        }
    }
}
