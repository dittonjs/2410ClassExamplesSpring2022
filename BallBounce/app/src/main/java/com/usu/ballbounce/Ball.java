package com.usu.ballbounce;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

public class Ball {
    int x;
    int y;
    int viewWidth;
    int viewHeight;
    double vX = 0;
    double vY = 0;

    public Ball(int x, int y, int viewWidth, int viewHeight) {
        this.x = x;
        this.y = y;
        this.viewWidth = viewWidth;
        this.viewHeight = viewHeight;
    }
    public void checkCollision(Ball ball) {
        // check for a collision handle according
    }
    public void update(double deltaT) {
        vY = vY + (9.8 * 5 * deltaT);
        y = (int)(y + vY);


        if (y + 50 >= viewHeight) {
            y = viewHeight - 50;
            vY = -1 * vY + 10;
        }
//        System.out.println(deltaT);
    }

    public void render(Canvas canvas, Paint paint) {
        canvas.translate(x, y);
        paint.setColor(Color.CYAN);
        canvas.drawCircle(0,0, 50, paint);
    }
}
