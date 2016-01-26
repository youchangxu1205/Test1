package cn.jldt.ms.test;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

/**
 * @author xuchangyou
 * @filename BaseActivity
 * @date: 2016/1/21 10:08
 */
public abstract class BaseActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView();
        findView();
        setListener();
    }

    public abstract void setContentView();

    public abstract void setListener();

    public abstract void findView();


}
