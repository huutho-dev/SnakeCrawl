package com.huutho.snakecrawl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.huutho.snakecrawl.R;
import com.huutho.snakecrawl.SnakeService;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by hnc on 03/08/2017.
 */

public class StartActivity extends AppCompatActivity {
    
    @BindView(R.id.img_back)
    ImageView mImgBack;
    @BindView(R.id.img_show)
    Button mImgShow;
    @BindView(R.id.textView2)
    TextView mTextView2;


    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.img_back)
    public void onBackPress() {
        finish();
    }

    @OnClick(R.id.img_show)
    public void showSnake() {
        Intent intent = new Intent(this, SnakeService.class);
        startService(intent);
        System.exit(0);
    }
}
