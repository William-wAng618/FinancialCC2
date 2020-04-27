package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.Button;
import android.widget.Toast;

/**
 * Created by admin on 2019/4/18.
 */

public class addMarkActivity extends Activity implements View.OnClickListener{
    private Button button_page777_1,button_page777_2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.page777);
        button_page777_1=(Button)findViewById(R.id.button_page777_1);
        button_page777_2=(Button)findViewById(R.id.button_page777_2);
        button_page777_1.setOnClickListener(this);
        button_page777_2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_page777_1:
                Toast.makeText(this,"操作成功",Toast.LENGTH_SHORT).show();
                intent=getIntent();
                intent.setClass(this,MenuActivity.class);
                startActivity(intent);
                break;
            case R.id.button_page777_2:
                finish();
                break;
        }

    }
}
