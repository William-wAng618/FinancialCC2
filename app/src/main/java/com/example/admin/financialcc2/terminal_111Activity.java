package com.example.admin.financialcc2;

import android.app.Activity;
import android.app.DatePickerDialog;
import android.content.ContentValues;
import android.content.Intent;
import android.content.SharedPreferences;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.SpinnerAdapter;
import android.widget.TextView;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

import com.example.admin.financialcc2.util.DBOpenHelper;
import com.example.admin.financialcc2.model.outaccountInfo;
/**
 * Created by admin on 2019/4/17.
 */

public class terminal_111Activity extends AppCompatActivity implements View.OnClickListener{
    private TextView mDatePicker;
    private DatePickerDialog.OnDateSetListener mDateSetLinster;
    private static final String TAG="terminal_111Activity";
    private Button button_page111_2,button_page111_3;
    private DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
    private String time,type,mark,money;
    private EditText editText_page111_1,editText_page111_2;
    private Spinner Spinner;
    private outaccountInfo outaccountInfo;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page111);
        button_page111_2=(Button)findViewById(R.id.button_page111_2);
        button_page111_3=(Button)findViewById(R.id.button_page111_3);
        button_page111_3.setOnClickListener(this);
        button_page111_2.setOnClickListener(this);
        Spinner=(Spinner)findViewById(R.id.Spinner);
        editText_page111_1=(EditText)findViewById(R.id.editText_page111_1);
        editText_page111_2=(EditText)findViewById(R.id.editText_page111_2);
        mDatePicker= (TextView) findViewById(R.id.button_page111_1);
        //取bundle
        try{
        Intent intent = getIntent();
        Bundle bundle= intent.getExtras();
        outaccountInfo=(outaccountInfo)bundle.get("outaccountInfo");
        editText_page111_1.setText(String.valueOf(outaccountInfo.getMoney()));
        //根据数据库中type的值设定Spinner的选项
        SpinnerAdapter apsAdapter= Spinner.getAdapter();
        int k= apsAdapter.getCount();
        for(int i=0;i<k;i++){
            if(outaccountInfo.getType().equals(apsAdapter.getItem(i).toString())){
                Spinner.setSelection(i,true);
                break;
            }
        }
            editText_page111_2.setText(outaccountInfo.getMark());
            mDatePicker.setText(outaccountInfo.getTime());
        }catch(NullPointerException e){}


        mDatePicker.setOnClickListener(new View.OnClickListener(){
            Calendar cal = Calendar.getInstance();
            int year = cal.get(Calendar.YEAR);
            int month = cal.get(Calendar.MONTH);
            int day = cal.get(Calendar.DAY_OF_MONTH);

            @Override
            public void onClick(View v) {

                DatePickerDialog dialog = new DatePickerDialog(
                        terminal_111Activity.this,
                        android.R.style.Theme_Holo_Dialog_MinWidth,
                        mDateSetLinster,
                        year, month, day);
                dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
                dialog.show();
            }
        });
        mDateSetLinster=new DatePickerDialog.OnDateSetListener(){

            @Override
            public void onDateSet(DatePicker view, int year, int month, int day) {
                Log.d(TAG, "onDateSet: date: " + year + "/" + month + "/" + day);
                int rm = month + 1;
                mDatePicker.setText(year + "/" + rm + "/" + day);// 可以通过mDatePicker.getText().toString();取出日期
            }
        };
        DBOpenHelper dbOpenHelper=new DBOpenHelper(this);
        dbOpenHelper.getWritableDatabase();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_page111_2:
                time=mDatePicker.getText().toString();
                money=editText_page111_1.getText().toString();
                mark=editText_page111_2.getText().toString();
                type=Spinner.getSelectedItem().toString();
                SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
                ContentValues contentValues=new ContentValues();
                contentValues.put("time",time);
                contentValues.put("money",money);
                contentValues.put("mark",mark);
                contentValues.put("type",type);
                db.insert("tb_outaccount",null,contentValues);
                //通过Tools->Android->Android Device Monitor中找到st.db文件来查看是否插入成功
                //st.db文件在data/com.example.admin.financialcc2/databases目录下
                Intent intent=getIntent();
                intent.setClass(this,MenuActivity.class);
                startActivity(intent);
                Toast.makeText(this,"操作成功"+":"+time+"在"+type+"上花了"+money+"元",Toast.LENGTH_SHORT).show();
                break;
            case R.id.button_page111_3:
                finish();
                break;
        }


    }
}
