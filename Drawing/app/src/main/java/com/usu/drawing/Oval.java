package com.usu.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;

public class Oval extends Shape {
    int wr;
    int hr;
    int x;
    int y;
    public Oval (int wr, int hr, int x, int y) {
        this.wr = wr;
        this.hr = hr;
        this.x = x;
        this.y = y;
    }

    @Override
    public void render(Canvas canvas, Paint paint) {
        canvas.translate(this.x, this.y);
        canvas.drawOval(0, 0, this.wr, this.hr, paint);
    }

    @Override
    public void setWidth(int width) {
        this.wr = width;
    }

    @Override
    public void setHeight(int height) {
        this.hr = height;
    }
}
