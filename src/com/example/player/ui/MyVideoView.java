package com.example.player.ui;

import android.content.Context;
import android.util.AttributeSet;
import android.view.SurfaceView;

public class MyVideoView extends SurfaceView {

    public static int WIDTH;
    public static int HEIGHT;


    public MyVideoView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }
    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        int width = getDefaultSize(WIDTH, widthMeasureSpec);
        int height = getDefaultSize(HEIGHT, heightMeasureSpec);
        setMeasuredDimension(width, height);
    }
}