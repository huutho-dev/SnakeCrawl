package com.huutho.snakecrawl.activity;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

import com.huutho.snakecrawl.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hnc on 03/08/2017.
 */

public class AdviceActivity extends AppCompatActivity {
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_advice);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.img_back)
    public void onBackPress(){
        finish();
    }
}
