package cn.jldt.ms.test;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.content.res.Resources;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.Button;

import com.socks.library.KLog;

public class MainActivity extends BaseActivity implements View.OnClickListener {

    private Button expandableBtn;
    private Button handleBtn;
    private Button cardViewBtn;

    @Override
    public void setContentView() {
        setContentView(R.layout.activity_main);
    }

    public void setListener() {
        expandableBtn.setOnClickListener(this);
        handleBtn.setOnClickListener(this);
        cardViewBtn.setOnClickListener(this);
    }

    public void findView() {
        expandableBtn = (Button) findViewById(R.id.expandable_btn);
        handleBtn = (Button) findViewById(R.id.handle_btn);
        cardViewBtn = (Button) findViewById(R.id.card_view_btn);
    }

    /**
     * Called when a view has been clicked.
     *
     * @param v The view that was clicked.
     */
    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.expandable_btn:
                ExpandableListViewActivity.actionStart(this);
                break;
            case R.id.handle_btn:
                HandleActivity.actionStart(this);
                break;
            case R.id.card_view_btn:
                CardViewActivity.actionStart(this);
                break;
        }
    }

}
