package com.example.bluetoothchatclient;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.ViewConfiguration;

import java.lang.reflect.Field;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //解决在部分手机上不显示overflow（三点图标）的问题
        getOverflowMenu();
    }

    /**
     * force to show overflow menu in actionbar
     *
     *【已解决】Android中ActionBar中不显示overflow（就是三个点的那个按钮） – 在路上
     * https://www.crifan.com/android_actionbar_three_dot_overflow_not_show/
     */
    private void getOverflowMenu() {
        try {
            ViewConfiguration config = ViewConfiguration.get(this);
            Field menuKeyField = ViewConfiguration.class.getDeclaredField("sHasPermanentMenuKey");
            if(menuKeyField != null) {
                menuKeyField.setAccessible(true);
                menuKeyField.setBoolean(config, false);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
