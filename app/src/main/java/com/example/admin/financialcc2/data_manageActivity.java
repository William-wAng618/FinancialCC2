package com.example.admin.financialcc2;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

/**
 * Created by admin on 2019/4/18.
 */

public class data_manageActivity extends Activity implements View.OnClickListener{
    private Button button_data_manage_1,button_data_manage_2;
    private Intent intent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.data_manage);
        button_data_manage_1=(Button)findViewById(R.id.button_data_manage_1);
        button_data_manage_2=(Button)findViewById(R.id.button_data_manage_2);
        button_data_manage_1.setOnClickListener(this);
        button_data_manage_2.setOnClickListener(this);

    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.button_data_manage_1:
                intent=getIntent();
                intent.setClass(this,terminal_111Activity.class);
                startActivity(intent);
                break;
            case R.id.button_data_manage_2:
                intent=getIntent();
                intent.setClass(this,terminal_222Activity.class);
                startActivity(intent);
                break;
        }
    }
}
