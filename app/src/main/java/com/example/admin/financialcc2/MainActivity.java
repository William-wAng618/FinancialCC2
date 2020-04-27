package com.example.admin.financialcc2;

import android.content.Intent;
import android.content.SharedPreferences;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;
import com.example.admin.financialcc2.util.DBOpenHelper;

public class MainActivity extends AppCompatActivity implements View.OnClickListener
{
    private Button button1,button2;
    private EditText editText1;
    private String password;
    private DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
    private SharedPreferences sharedPreferences;
    private SharedPreferences.Editor editor;
    private CheckBox checkBox_main;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    button1=(Button)findViewById(R.id.button1);
    button2=(Button)findViewById(R.id.button2);
    button1.setOnClickListener(this);
    button2.setOnClickListener(this);
    editText1=(EditText)findViewById(R.id.editText1);
    checkBox_main=(CheckBox)findViewById(R.id.checkBox_main);
    DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
    dbOpenHelper.getWritableDatabase();
    //生成文件
    //第一个参数：文件
    //第二个参数：权限
    //MODE_PRIVATE只能被当前APP访问
    sharedPreferences=getSharedPreferences("myPref",MODE_PRIVATE);
    editor=sharedPreferences.edit();
    editText1.setText(sharedPreferences.getString("password",""));

}

    @Override
    public void onClick(View v) {
        Intent intent=getIntent();
        switch (v.getId()){
            case R.id.button1://登录
                password=editText1.getText().toString();
                String[]args={password};
                //查询条件的值
                SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
//查询，返回游标对象
                Cursor cursor=db.query("tb_pwd",null,null,null,null,null,null);
                Toast.makeText(this,"cursor2的值是："+cursor.getCount(),Toast.LENGTH_SHORT).show();
                if(cursor.getCount()!=0){
//                    Cursor cursor=db.query("tb_pwd",null,null,null,null,null,null);
                    if(cursor!= null){
                        if(cursor.moveToNext()){//如果有查询的记录
                            String pwd = cursor.getString(cursor.getColumnIndex("password"));
                            if(pwd.equals(password)){ //比较密码是否一致
                            Intent intentINIT=new Intent(this,MenuActivity.class);
                                //单选框
                                if (checkBox_main.isChecked()){
                                    editor.putString("password",password);
                                    editor.commit();
                                }else{//如果没有选中，则清空保存的用户名和密码
                                    editor.remove("password");
                                    editor.commit();

                                }
//                                intent.setClass(this,MenuActivity.class);
                                startActivity(intentINIT);
                            }else{ //不相同
                                Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
                            }
                        }
                        else{//没有查询到
//                        Intent intent2=new Intent(this,Main2Activity.class);
                            intent.setClass(this,Main2Activity.class);
                            startActivity(intent);
                            Toast.makeText(this,"11111111111111",Toast.LENGTH_SHORT).show();
                            Toast.makeText(this,"cursor2的值是："+cursor.getCount(),Toast.LENGTH_SHORT).show();
                        }
                    }
//                    Intent intent2=new Intent(this,Main2Activity.class);
//                    startActivity(intent2);
                }
                else{
//                    Intent intent2=new Intent(this,Main2Activity.class);
                    intent.setClass(this,Main2Activity.class);
                    Toast.makeText(this,"2222222222222222",Toast.LENGTH_SHORT).show();
                    Toast.makeText(this,"cursor2的值是："+cursor.getCount(),Toast.LENGTH_SHORT).show();
                    startActivity(intent);
                }//                if(cursor != null){
//                    if(cursor.moveToNext()){//如果有查询的记录
//                        String pwd = cursor.getString(cursor.getColumnIndex("password"));

//                        if(pwd.equals(password)){ //比较密码是否一致
//                            Intent intentSIGNIN=new Intent(this,MenuActivity.class);
////                            intent.setClass(this,MenuActivity.class);
//                            startActivity(intentSIGNIN);
//                        }else{ //不相同
//                            Toast.makeText(this,"密码错误",Toast.LENGTH_SHORT).show();
//                        }
//                    }else{//没有查询到
//                        Intent intent2=new Intent(this,Main2Activity.class);
//                        startActivity(intent2);
//                    }
//                }


                break;
            case R.id.button2://退出
                finish();
                break;
        }
    }
}
