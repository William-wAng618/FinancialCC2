package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.ContentValues;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.admin.financialcc2.util.DBOpenHelper;

/**
 * Created by admin on 2019/4/16.
 */

public class Main2Activity extends Activity implements View.OnClickListener{
    private static final String TAG="Main2Activity";
    private Button button_activity_main2_1,button_activity_main2_2;
    private EditText editText_activity_main2_1;
    private String password;
    private DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        editText_activity_main2_1=(EditText)findViewById(R.id.editText_activity_main2_1);
        button_activity_main2_1=(Button)findViewById(R.id.button_activity_main2_1);
        button_activity_main2_2=(Button)findViewById(R.id.button_activity_main2_2);
        button_activity_main2_1.setOnClickListener(this);
         button_activity_main2_2.setOnClickListener(this);
        password=editText_activity_main2_1.getText().toString();
        DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
        dbOpenHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_activity_main2_1://主界面2的注册按钮

                password=editText_activity_main2_1.getText().toString();
                Log.d(TAG,password);
                SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
                //创建contentvalue对象
                ContentValues contentValues=new ContentValues();
                //把想插入的
                contentValues.put("password",password);
                db.insert("tb_pwd",null,contentValues);
//                Intent intent=getIntent();
//                intent.setClass(this,MainActivity.class);
//                startActivity(intent);
                Intent intent=new Intent(this,MainActivity.class);
                startActivity(intent);
//                Toast.makeText(this,"注册成功", Toast.LENGTH_SHORT).show();

                break;
            case R.id.button_activity_main2_2:
                finish();
                break;
        }
    }
}
