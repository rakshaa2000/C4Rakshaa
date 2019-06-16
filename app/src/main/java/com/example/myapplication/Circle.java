package com.example.myapplication;

import android.graphics.Color;
import android.graphics.Paint;

public class Circle {
    public float x, y, rad;
    public Paint paint;
    public Circle(){
        x=0;
        y=0;
        rad=0;
        paint= new Paint();
        paint.setColor(Color.RED);
    }
}
