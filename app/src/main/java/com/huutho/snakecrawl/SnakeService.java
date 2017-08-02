package com.huutho.snakecrawl;

import android.app.Service;
import android.content.Intent;
import android.os.IBinder;
import android.support.annotation.Nullable;

/**
 * Created by hnc on 01/08/2017.
 */

public class SnakeService extends Service {

    @Override
    public void onCreate() {
        super.onCreate();
        SnakeManager snakeManager = new SnakeManager(this);
    }

    @Nullable
    @Override
    public IBinder onBind(Intent intent) {
        return null;
    }

}
