package com.usu.drawing;

import android.graphics.Canvas;
import android.graphics.Paint;

public abstract class Shape {
    public abstract void render(Canvas canvas, Paint paint);
    public abstract void setWidth(int width);
    public abstract void setHeight(int height);
}
