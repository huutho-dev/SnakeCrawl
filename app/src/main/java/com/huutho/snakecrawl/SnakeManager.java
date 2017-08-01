package com.huutho.snakecrawl;

import android.content.Context;
import android.os.Handler;
import android.view.View;

import java.util.Random;

/**
 * Created by hnc on 01/08/2017.
 */

public class SnakeManager {
    private final int TIME_MOVE = 13;
    private final int DISTANCE_MOVE = 3;

    private Random mRandom;
    private Handler mHandler;
    private Runnable runnable;
    private View mView;

    private int widthView;
    private int heightView;

    private int widthScreen;
    private int heightScreen;

    public SnakeManager(Context context, View view) {

        this.mView = view;
        this.widthView = view.getWidth();
        this.heightView = view.getHeight();
        this.widthView = Utils.getWidthScreen(context);
        this.heightScreen = Utils.getHeightScreen(context);

        mRandom = new Random();
        mHandler = new Handler();
    }

    public void moveHorizontalToLeft() {
        mView.setX(widthView/2);
        mView.setY(randomHeight());
        removeHandler();

        runnable = new Runnable() {
            @Override
            public void run() {
                float newX = mView.getX() + DISTANCE_MOVE;
                mView.setX(newX);
                mHandler.postDelayed(runnable, TIME_MOVE);
            }
        };

        postHandler(runnable);
    }

    public void moveHorizontalToRight() {

    }

    public void moveVertical() {

    }

    public void moveCross() {

    }

    private void removeHandler() {
        if (mHandler != null) {
            mHandler.removeCallbacks(runnable);
        }
    }

    private void postHandler(Runnable runnable) {
        mHandler.post(runnable);
    }

    private int randomHeight() {
        return mRandom.nextInt(heightScreen);
    }

    private int randomWidth() {
        return mRandom.nextInt(widthScreen);
    }
}
