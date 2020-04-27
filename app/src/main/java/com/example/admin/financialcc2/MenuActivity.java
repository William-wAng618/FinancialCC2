package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.AdapterView;
import android.widget.GridView;
import android.widget.SimpleAdapter;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created by admin on 2019/4/11.
 */

public class MenuActivity extends Activity implements AdapterView.OnItemClickListener{
    private static final String TAG="MenuActivity";
    //grid_view需要显示的所有的菜单数据
    private List<Map<String,Object>> data;
    //定义一个适配器
    private SimpleAdapter simpleAdapter;
    private GridView gridView;
    private Intent intent;
    //定义菜单项图标R类为int类
    private int[]icons={R.drawable.menu1,R.drawable.menu2,R.drawable.menu3,
            R.drawable.menu4,R.drawable.menu5,R.drawable.menu6,R.drawable.menu7,R.drawable.menu8,
    };//meun1为图片
    private String[]titles={"新增支出","新增收入","我的支出","我的收入","数据管理","重置密码","收支便签","退出"};
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.menu);
        gridView=(GridView)findViewById(R.id.grid_view);
        //适配器是显示什么数据，与样式
        init();
        //第一个参数：上下文
        //第二个参数：需要显示的数据
        //第三个参数：每一个选项显示的样式
        //第四个参数：数据list中hashmap的键
        //第五个参数：第四个参数中的数组中的键的值对应的需要显示的组件的id
        simpleAdapter=new SimpleAdapter(this,data,R.layout.grid_item,
                new String[]{"icon","title"},new int[]{R.id.grid_imageView,R.id.grid_textView});
        gridView.setAdapter(simpleAdapter);
        gridView.setOnItemClickListener(this);



    }
    //初始化菜单上的数据
    public void init(){
        data=new ArrayList<>();
        //遍历图标数组
        for(int i=0;i<icons.length;i++){
            //构造每一个菜单项的HashMap
            Map<String,Object> item=new HashMap<>();
            item.put("icon",icons[i]);
            item.put("title",titles[i]);
            data.add(item);
        }
        Log.d(TAG, data.toString());
    }
    /**
     * 每一个选项点击事件触发的方法
     * @param parent
     * @param view
     * @param position
     * @param id
     */
    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

        switch (position) {
            case 0:
                intent=getIntent();
                intent.setClass(this,terminal_111Activity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 1:
                intent=getIntent();
                intent.setClass(this,terminal_222Activity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 2:
                intent=getIntent();
                intent.setClass(this,terminal_333Activity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 3:
                intent=getIntent();
                intent.setClass(this,terminal_444Activity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 4:
                intent=getIntent();
                intent.setClass(this,data_manageActivity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 5:
                intent=getIntent();
                intent.setClass(this,terminal_555Activity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 6:
                intent=getIntent();
                intent.setClass(this,addMarkActivity.class);
//                Intent intent=new Intent(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case 7:
                finish();
                break;



        }

    }
}