package com.mizhi.itemtouchhelperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;

import com.mizhi.itemtouchhelperdemo.activity.GridActivity;
import com.mizhi.itemtouchhelperdemo.activity.LinearActivity;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {
    private Button mLinearTextView;
    private Button mGridTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
    }

    private void initView() {
        mLinearTextView = findViewById(R.id.tv_main_linear);
        mGridTextView = findViewById(R.id.tv_main_grid);
    }

    private void initData() {
        mLinearTextView.setOnClickListener(this);
        mGridTextView.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.tv_main_linear:
                toNewActivity(LinearActivity.class);
                break;
            case R.id.tv_main_grid:
                toNewActivity(GridActivity.class);
                break;

        }
    }

    private void toNewActivity( Class<?> cls){
        startActivity(new Intent(this,cls));
    }
}
