package com.huutho.snakecrawl;

import android.app.Application;

/**
 * Created by hnc on 02/08/2017.
 */

public class AppController extends Application {

    private static AppController instance;

    public synchronized static AppController getInstance() {
        if (instance == null){
            instance = new AppController();
        }
        return instance;
    }

    @Override
    public void onCreate() {
        super.onCreate();
        instance = this;
    }
}
