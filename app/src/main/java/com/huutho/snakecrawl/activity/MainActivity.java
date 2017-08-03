package com.huutho.snakecrawl.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.huutho.snakecrawl.R;

import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.btn_start)
    public void snakeStart() {
        startActivity(new Intent(this, StartActivity.class));
    }

    @OnClick(R.id.btn_advice)
    public void snakeAdvice() {
        startActivity(new Intent(this, AdviceActivity.class));
    }

    @OnClick(R.id.btn_advice)
    public void snakeFeedback() {
        //TODO: feed back

    }
}
