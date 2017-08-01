package com.huutho.snakecrawl;

import android.app.Service;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.os.IBinder;
import android.support.annotation.Nullable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.ImageView;

/**
 * Created by hnc on 01/08/2017.
 */

public class SnakeService extends Service {

    private SnakeManager mSnakeManager;
    private ImageView mSnakeView;


    @Override
    public void onCreate() {
        super.onCreate();

        View view = LayoutInflater.from(this).inflate(R.layout.snake, null);
        mSnakeView = view.findViewById(R.id.image);

        AnimationDrawable animationDrawable = (AnimationDrawable) mSnakeView.getBackground();
        animationDrawable.start();


        WindowManager.LayoutParams p
                = new WindowManager.LayoutParams(
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY,
                WindowManager.LayoutParams.FLAG_FULLSCREEN
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
                        | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED,
                PixelFormat.TRANSLUCENT);

        p.gravity = Gravity.TOP | Gravity.LEFT;
        p.x = 0;
        p.y = 0;

        WindowManager wm = (WindowManager) getSystemService(WINDOW_SERVICE);
        wm.addView((View) mSnakeView.getParent(), p);

        mSnakeManager = new SnakeManager(this, mSnakeView);
        mSnakeManager.moveHorizontalToLeft();
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
