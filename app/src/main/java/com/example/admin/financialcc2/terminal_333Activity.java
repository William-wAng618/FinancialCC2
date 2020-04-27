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

import com.example.admin.financialcc2.model.outaccountInfo;
import com.example.admin.financialcc2.util.DBOpenHelper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
/**
 * Created by admin on 2019/4/18.
 */

public class terminal_333Activity extends Activity implements AdapterView.OnItemClickListener {
    private static final String TAG = "terminal_333Activity";

    private ListView listView;
    private List<outaccountInfo> data;
    private terminal_333Adapter terminal_333Adapter;
    private DBOpenHelper dbOpenHelper;
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.page333);
        listView=(ListView)findViewById(R.id.list_view_page333);
        dbOpenHelper=new DBOpenHelper(this);
        data=getData();
        terminal_333Adapter=new terminal_333Adapter(this.data,this);
        listView.setAdapter(terminal_333Adapter);
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
        terminal_333Adapter.notifyDataSetChanged();

    }

    public List<outaccountInfo> getData() {
        List<outaccountInfo>list=new ArrayList<>();
        SQLiteDatabase db=dbOpenHelper.getWritableDatabase();
        Cursor cursor=db.query("tb_outaccount",null,null,null,null,null,null);
        if (cursor!=null){
            for (cursor.moveToFirst();!cursor.isAfterLast();cursor.moveToNext()){
                outaccountInfo outaccountInfo=new outaccountInfo();
                outaccountInfo.set_id(cursor.getInt(cursor.getColumnIndex("_id")));
                outaccountInfo.setType(cursor.getString(cursor.getColumnIndex("type")));
                outaccountInfo.setMoney(cursor.getFloat(cursor.getColumnIndex("money")));
                outaccountInfo.setTime(cursor.getString((cursor.getColumnIndex("time"))));
                outaccountInfo.setMark(cursor.getString((cursor.getColumnIndex("mark"))));
                list.add(outaccountInfo);
            }
        }
        return list;
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        outaccountInfo outaccountInfo=data.get(position);
        Log.d(TAG, "onItemClick() called with: parent = [" + parent + "], view = [" + view + "], position = [" + position + "], id = [" + id + "]");
        Intent intent = getIntent();
        intent.setClass(this,AlterOutaccount.class);
        Bundle bundle = new Bundle();
        //把需要传的对象(必须要序列化)放入bundle
        bundle.putSerializable("outaccountInfo",outaccountInfo);
        intent.putExtras(bundle);
        startActivity(intent);
    }
}