package com.huutho.snakecrawl;

import android.content.Context;
import android.graphics.PixelFormat;
import android.graphics.drawable.AnimationDrawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;

import static android.content.Context.WINDOW_SERVICE;

/**
 * Created by hnc on 02/08/2017.
 */

public class SnakeWindowManager {

    private final static int lParamWidth = WindowManager.LayoutParams.WRAP_CONTENT;
    private final static int lParamHeight = WindowManager.LayoutParams.WRAP_CONTENT;
    private final static int lParamType = WindowManager.LayoutParams.TYPE_SYSTEM_OVERLAY;
    private final static int lParamFlag = WindowManager.LayoutParams.FLAG_FULLSCREEN
            // make move view outside screen
            | WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
            | WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
            | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
            | WindowManager.LayoutParams.FLAG_NOT_TOUCHABLE
            | WindowManager.LayoutParams.FLAG_HARDWARE_ACCELERATED;
    private final static int lParamFormat = PixelFormat.TRANSLUCENT;


    private WindowManager.LayoutParams mLayoutParams;
    private WindowManager mWindowManager;
    private View mView;
    private int widthView, heightView;

    public SnakeWindowManager(Context context) {

        mView = LayoutInflater.from(context).inflate(R.layout.snake, null);
        mView.measure(
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.EXACTLY),
                View.MeasureSpec.makeMeasureSpec(0, View.MeasureSpec.UNSPECIFIED));

        AnimationDrawable animationDrawable = (AnimationDrawable) mView.findViewById(R.id.image).getBackground();
        animationDrawable.start();

        mLayoutParams = new WindowManager.LayoutParams(lParamWidth, lParamHeight, lParamType, lParamFlag, lParamFormat);
        mLayoutParams.gravity = Gravity.TOP | Gravity.LEFT;
        mLayoutParams.x = 0;
        mLayoutParams.y = 0;
        mWindowManager = (WindowManager) context.getSystemService(WINDOW_SERVICE);
        mWindowManager.addView(mView, mLayoutParams);
    }

    public WindowManager.LayoutParams getLayoutParams() {
        return mLayoutParams;
    }

    public View getView() {
        return mView;
    }

    public void updateSnakeLayout() {
        mWindowManager.updateViewLayout(mView, mLayoutParams);
    }

    /**
     * @param x : newX of snake will be update
     * @param y : newY of snake will be update
     */
    public void updateSnakeLayout(int x, int y) {
        mLayoutParams.x = x;
        mLayoutParams.y = y;
        mWindowManager.updateViewLayout(mView, mLayoutParams);
    }
}
