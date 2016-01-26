package cn.jldt.ms.test;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ImageView;

/**
 * @author xuchangyou
 * @filename HandleActivity
 * @date: 2016/1/19 17:37
 */


public class HandleActivity extends Activity {
    private ImageView imageView = null;
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case 0:
                    imageView.setImageResource(R.mipmap.p1);
                    break;
                case 1:
                    imageView.setImageResource(R.mipmap.p2);
                    break;
                case 2:
                    imageView.setImageResource(R.mipmap.p3);
                    break;
                case 3:
                    imageView.setImageResource(R.mipmap.p4);
                    break;
            }
            super.handleMessage(msg);
        }
    };

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_handle);

        imageView = (ImageView) findViewById(R.id.imageView);
        thread.start();
    }

    int what = 0;
    Thread thread = new Thread(new Runnable() {

        public void run() {
            while (true) {
                handler.sendEmptyMessage((what++) % 4);
                try {
                    Thread.sleep(10);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

        }
    });

    public static void actionStart(Activity activity) {
        Intent intent = new Intent(activity, HandleActivity.class);
        activity.startActivity(intent);
    }

}
