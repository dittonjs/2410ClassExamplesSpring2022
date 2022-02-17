package com.usu.drawing;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Square extends Shape {
    int width;
    int height;
    int x;
    int y;

    public Square(int width, int height, int x, int y) {
        this.width = width;
        this.height = height;
        this.x = x;
        this.y = y;
    }



    public void render(Canvas canvas, Paint paint) {
        paint.setColor(Color.BLUE);
        canvas.translate(x, y);
        canvas.drawRect(
                0,
                0,
                width,
                height,
                paint
        );
    }

    @Override
    public void setWidth(int width) {
        this.width = width;
    }

    @Override
    public void setHeight(int height) {
        this.height = height;
    }
}
