package com.example.admin.financialcc2;

import android.content.ContentValues;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;
import android.content.Context;

import java.util.List;
import com.example.admin.financialcc2.model.inaccountInfo;
/**
 * Created by admin on 2019/4/18.
 */

public class terminal_444Adapter extends BaseAdapter{
    private static final String TAG = "terminal_444Adapter";

    private List<inaccountInfo> list;
    private LayoutInflater layoutInflater;
    public terminal_444Adapter(List<inaccountInfo>list,Context content){
        this.list = list;
        this.layoutInflater = LayoutInflater.from(content);
    }
    @Override
    public int getCount() {
        return list.size();
    }

    @Override
    public Object getItem(int position) {
        return list.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        Log.d(TAG, "getView() called with: position = [" + position + "], convertView = [" + convertView + "], parent = [" + parent + "]");
        if (convertView==null){
            convertView=layoutInflater.inflate(R.layout.grid_item_1,null);
        }
        TextView _idTextView=(TextView)convertView.findViewById(R.id.textView_gridItem_333_1);
        TextView typeTextView=(TextView)convertView.findViewById(R.id.textView_gridItem_333_2);
        TextView moneyTextView=(TextView)convertView.findViewById(R.id.textView_gridItem_333_3);
        TextView timeTextView=(TextView)convertView.findViewById(R.id.textView_gridItem_333_4);

        inaccountInfo inaccountInfo=list.get(position);
        int _id=inaccountInfo.get_id();
        String type=inaccountInfo.getType();
        float money=inaccountInfo.getMoney();
        String time=inaccountInfo.getTime();

        _idTextView.setText(String.valueOf(_id));
        typeTextView.setText(type);
        moneyTextView.setText(String.valueOf(money));
        timeTextView.setText(time);
        return convertView;
    }
}
