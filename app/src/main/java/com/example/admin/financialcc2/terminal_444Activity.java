package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.admin.financialcc2.model.inaccountInfo;
import com.example.admin.financialcc2.util.DBOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by admin on 2019/4/18.
 */

public class terminal_444Activity extends Activity implements AdapterView.OnItemClickListener{

    private static final String TAG = "terminal_444Activity";

    private ListView listView;
    private List<inaccountInfo> data;
    private terminal_444Adapter terminal_444Adapter;
    private DBOpenHelper dbOpenHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page444);
        listView=(ListView)findViewById(R.id.list_view_page444);
        dbOpenHelper=new DBOpenHelper(this);
        data=getData();
        terminal_444Adapter=new terminal_444Adapter(this.data,this);
        listView.setAdapter(terminal_444Adapter);
        listView.setOnItemClickListener(this);


    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Log.d(TAG, "onRestart() called");
        //清空列表
        data.clear();
        //取列表数据
        data.addAll(getData());
        //通知适配器数据更新
        terminal_444Adapter.notifyDataSetChanged();

    }

    public List<inaccountInfo> getData() {
        List<inaccountInfo>list=new ArrayList<>();
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        Cursor cursor=db.query("tb_inaccount",null,null,null,null,null,null);
        if (cursor!=null){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                inaccountInfo inaccountInfo=new inaccountInfo();
                inaccountInfo.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                inaccountInfo.setType(cursor.getString(cursor.getColumnIndex("type")));
                inaccountInfo.setMoney(cursor.getFloat(cursor.getColumnIndex("money")));
                inaccountInfo.setTime(cursor.getString((cursor.getColumnIndex("time"))));
                inaccountInfo.setMark(cursor.getString((cursor.getColumnIndex("mark"))));
                list.add(inaccountInfo);
            }
        }
        return list;
    }
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        inaccountInfo inaccountInfo=data.get(position);
        Log.d(TAG, "onItemClick() called with: parent = [" + parent + "], view = [" + view + "], position = [" + position + "], id = [" + id + "]");
        Intent intent = getIntent();
        intent.setClass(this,AlterInaccount.class);
        Bundle bundle = new Bundle();
        //把需要传的对象(必须要序列化)放入bundle
        bundle.putSerializable("inaccountInfo",inaccountInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}
