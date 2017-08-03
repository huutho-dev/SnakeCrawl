package com.huutho.snakecrawl;

import android.content.Context;
import android.os.Handler;

import java.util.Random;

/**
 * Created by hnc on 01/08/2017.
 */

public class SnakeManager {
    private final int TIME_MOVE = 5;
    private final int DISTANCE_MOVE =2;

    private int widthScreen;
    private int heightScreen;

    private Random mRandom;
    private Handler mHandler;
    private Runnable mRunnable;
    private SnakeWindowManager mSnakeWindowManager;


    public SnakeManager(Context context) {
        this.mSnakeWindowManager = new SnakeWindowManager(context);
        this.widthScreen = Utils.getWidthScreen(context);
        this.heightScreen = Utils.getHeightScreen(context);
        this.mRandom = new Random();
        this.mHandler = new Handler();


        final Handler handler = new Handler();
        final Runnable runnable = new Runnable() {
            @Override
            public void run() {
                if (mRunnable == null) {
                    runSnake();
                }
                handler.postDelayed(this, 3000);
            }
        };
        handler.post(runnable);

    }

    public void runSnake() {
        int run = mRandom.nextInt(4);
        switch (run) {
            case 0:
                moveToLeft();
                break;
            case 1:
                moveToRight();
                break;
            case 2:
                moveToTop();
                break;
            case 3:
                moveToBottom();
                break;
        }
    }


    private void moveToRight() {
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
        rotateRight();
        setPositionOnLeft();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSnakeWindowManager.getLayoutParams().x += DISTANCE_MOVE;

                if (mSnakeWindowManager.getLayoutParams().x > widthScreen) {
                    mHandler.removeCallbacks(mRunnable);
                    mRunnable = null;
                }

                mSnakeWindowManager.updateSnakeLayout();
                mHandler.postDelayed(mRunnable, TIME_MOVE);

            }
        };
        mHandler.post(mRunnable);
    }

    private void moveToLeft() {
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
        rotateDefaultLeft();
        setPositionOnRight();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSnakeWindowManager.getLayoutParams().x -= DISTANCE_MOVE;

                if (mSnakeWindowManager.getLayoutParams().x < 0 - mSnakeWindowManager.getView().getWidth()) {
                    mHandler.removeCallbacks(mRunnable);
                    mRunnable = null;
                }

                mSnakeWindowManager.updateSnakeLayout();
                mHandler.postDelayed(mRunnable, TIME_MOVE);
            }
        };
        mHandler.post(mRunnable);
    }

    private void moveToTop() {
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
        rotateTop();
        setPositionOnBottom();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSnakeWindowManager.getLayoutParams().y -= DISTANCE_MOVE;

                if (mSnakeWindowManager.getLayoutParams().y < 0 - mSnakeWindowManager.getView().getHeight()) {
                    mHandler.removeCallbacks(mRunnable);
                    mRunnable = null;
                }

                mSnakeWindowManager.updateSnakeLayout();
                mHandler.postDelayed(mRunnable, TIME_MOVE);
            }
        };
        mHandler.post(mRunnable);
    }

    private void moveToBottom() {
        mHandler.removeCallbacks(mRunnable);
        mRunnable = null;
        rotateBottom();
        setPositionOnTop();
        mRunnable = new Runnable() {
            @Override
            public void run() {
                mSnakeWindowManager.getLayoutParams().y += DISTANCE_MOVE;

                if (mSnakeWindowManager.getLayoutParams().y > heightScreen) {
                    mHandler.removeCallbacks(mRunnable);
                    mRunnable = null;
                }

                mSnakeWindowManager.updateSnakeLayout();
                mHandler.postDelayed(mRunnable, TIME_MOVE);
            }
        };
        mHandler.post(mRunnable);
    }


    private void setPositionOnLeft() {
        mSnakeWindowManager.getView().post(new Runnable() {
            @Override
            public void run() {
                int x = 0 - mSnakeWindowManager.getView().getWidth();
                int y = mRandom.nextInt(heightScreen) - mSnakeWindowManager.getView().getHeight() / 2;
                mSnakeWindowManager.updateSnakeLayout(x, y);
            }
        });
    }

    private void setPositionOnRight() {
        int x = widthScreen;
        int y = mRandom.nextInt(heightScreen) - mSnakeWindowManager.getView().getHeight() / 2;
        mSnakeWindowManager.updateSnakeLayout(x, y);
    }

    private void setPositionOnTop() {
        mSnakeWindowManager.getView().post(new Runnable() {
            @Override
            public void run() {
                int x = mRandom.nextInt(widthScreen) - mSnakeWindowManager.getView().getWidth() / 2;
                int y = 0 - mSnakeWindowManager.getView().getHeight();
                mSnakeWindowManager.updateSnakeLayout(x, y);
            }
        });
    }

    private void setPositionOnBottom() {
        int x = mRandom.nextInt(widthScreen) - mSnakeWindowManager.getView().getWidth() / 2;
        int y = heightScreen;
        mSnakeWindowManager.updateSnakeLayout(x, y);
    }


    // setRotation : rotate view
    // setRotationY: flip image inside View
    private void rotateDefaultLeft() {
        mSnakeWindowManager.getView().setRotation(0);
        mSnakeWindowManager.getView().setRotationY(0);
    }

    private void rotateRight() {
        mSnakeWindowManager.getView().setRotation(0);
        mSnakeWindowManager.getView().setRotationY(180);
    }

    private void rotateTop() {
        mSnakeWindowManager.getView().setRotation(90);
        mSnakeWindowManager.getView().setRotationY(0);
    }

    private void rotateBottom() {
        mSnakeWindowManager.getView().setRotation(-90);
        mSnakeWindowManager.getView().setRotationY(0);
    }


}
