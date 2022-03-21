package com.usu.drawing;

import android.animation.TimeInterpolator;
import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.renderscript.Sampler;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    Paint paint = new Paint();
    ArrayList<Shape> shapes = new ArrayList<>();
    Shape currentShape;
    float startX = 0;
    float startY = 0;

    public static enum Mode {
        Square,
        Circle,
    }

    Mode mode = Mode.Square;
    ValueAnimator animator;
    int radius = 100;
    public DrawingView(Context context) {

        super(context);

        animator = ValueAnimator.ofInt(100, 254);
        animator.setRepeatMode(ValueAnimator.REVERSE);
        animator.setDuration(1000);
//        animator.setInterpolator();
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator valueAnimator) {
                radius = (int)valueAnimator.getAnimatedValue();
                invalidate();
            }
        });
        animator.start();

        setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    if (mode == Mode.Square) currentShape = new Square(0, 0, (int)motionEvent.getX(), (int)motionEvent.getY());
                    else currentShape = new Oval(0, 0, (int)motionEvent.getX(), (int)motionEvent.getY());
                    startX = motionEvent.getX();
                    startY = motionEvent.getY();
                    shapes.add(currentShape);
                    invalidate();
                    return true;
                } else if (motionEvent.getAction() == MotionEvent.ACTION_MOVE) {
                    currentShape.setWidth((int)(motionEvent.getX() - startX));
                    currentShape.setHeight((int)(motionEvent.getY() - startY));
                    invalidate();
                } else if (motionEvent.getAction() == MotionEvent.ACTION_UP) {
                    currentShape = null;
                    invalidate();
                }
                return false;
            }
        });
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        paint.setColor(Color.rgb(radius % 255, 100, 100));
        canvas.translate(getWidth() / 2, getHeight() / 2);
        canvas.drawCircle(0, 0, radius, paint);

//        shapes.forEach(shape -> {
//            canvas.save();
//            shape.render(canvas, paint);
//            paint.reset();
//            canvas.restore();
//        });
    }
}
