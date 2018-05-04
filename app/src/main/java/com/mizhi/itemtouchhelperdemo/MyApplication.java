package com.mizhi.itemtouchhelperdemo;

import android.app.Application;
import android.content.Context;

/**
 * 类描述：
 *
 * @Author 许少东
 * Created at 2018/5/3.
 */

public class MyApplication extends Application {
    public static Context mAppContext;
    @Override
    public void onCreate() {
        super.onCreate();
        mAppContext = this;
    }
}
