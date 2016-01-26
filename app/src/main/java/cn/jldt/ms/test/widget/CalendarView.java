package cn.jldt.ms.test.widget;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * @author xuchangyou
 * @filename CalendarView
 * @date: 2016/1/19 18:33
 */
public class CalendarView extends View {
    public CalendarView(Context context) {
        super(context);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    public CalendarView(Context context, @Nullable AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
    }

    /**
     * 计算控件的宽高
     *
     * @param widthSpec
     * @param heightSpec
     */
    @Override
    protected void onMeasure(int widthSpec, int heightSpec) {
        setMeasuredDimension(getMeasureWidth(widthSpec), getMeasureHeight(heightSpec));
    }

    /**
     * 计算控件的高
     *
     * @param measureSpec
     * @return
     */
    private int getMeasureHeight(int measureSpec) {
        int result = 200;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                result = Math.min(result, specSize);
                break;

            case MeasureSpec.EXACTLY://精确
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }

        return result;
    }

    /**
     * 计算控件的宽
     *
     * @param measureSpec
     * @return
     */
    private int getMeasureWidth(int measureSpec) {
        int result = 200;
        int specMode = MeasureSpec.getMode(measureSpec);
        int specSize = MeasureSpec.getSize(measureSpec);

        switch (specMode) {
            case MeasureSpec.AT_MOST:
                result = Math.min(result, specSize);
                break;

            case MeasureSpec.EXACTLY://精确
                result = specSize;
                break;
            case MeasureSpec.UNSPECIFIED:
                break;
        }

        return result;
    }

    @Override
    protected void onDraw(Canvas canvas) {

        super.onDraw(canvas);
    }
}
