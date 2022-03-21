package com.usu.ballbounce;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.view.Choreographer;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

class Choreographer {
    static interface FrameCallback {
        //
    }
}

public class DrawingView extends View implements Choreographer.FrameCallback {
    ArrayList<Ball> balls = new ArrayList<>();
    long timestamp = 0;
    Paint paint = new Paint();
    @SuppressLint("ClickableViewAccessibility")
    public DrawingView(Context context) {
        super(context);
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                balls.add(
                        new Ball(
                                (int)motionEvent.getX(),
                                (int)motionEvent.getY(),
                                getWidth(),
                                getHeight()
                        )
                );
            }
            return false;
        });
        Choreographer.getInstance().postFrameCallback(this);
    }



    @Override
    public void doFrame(long l) {
        if (timestamp == 0) {
            timestamp = l;
            Choreographer.getInstance().postFrameCallback(this);
            return;
        }
        long deltaT = l - timestamp;
        timestamp = l;
        balls.forEach(ball -> {
            ball.update(deltaT / 1000.0 / 1000.0 / 1000.0);

            invalidate();
        });
        Choreographer.getInstance().postFrameCallback(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        balls.forEach(ball -> {
            canvas.save();
            paint.reset();
            ball.render(canvas, paint);
            canvas.restore();
        });
    }
}
