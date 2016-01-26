package cn.jldt.ms.test.widget;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.RelativeLayout;

import cn.jldt.ms.test.R;

/**
 * @author xuchangyou
 * @filename CommonTitleBar
 * @date: 2016/1/20 15:58
 */
public class CommonTitleBar extends RelativeLayout {
    public CommonTitleBar(Context context) {
        super(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }


    public void init(Context context){
        View view = LayoutInflater.from(context).inflate(R.layout.title_bar, this);
    }

}
