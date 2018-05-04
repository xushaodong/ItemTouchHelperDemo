package com.mizhi.itemtouchhelperdemo.activity;

import android.support.v7.app.AppCompatActivity;
import android.widget.Toast;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public class BaseActivity extends AppCompatActivity {

    protected void showToast(String text){
        Toast.makeText(this,text,Toast.LENGTH_SHORT).show();
    }

}
