package com.usu.aswitch;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

public class Switch extends View {
    int height;
    int width;
    int radius;
    int x;

    boolean isOn = false;
    Paint paint = new Paint();
    ValueAnimator animator;
    @SuppressLint("ClickableViewAccessibility")
    public Switch(Context context, int height) {
        super(context);
        this.height = height;
        this.width = 2*height;
        radius = (height - 20) / 2;
        x = 10  + radius;
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, height);
        setLayoutParams(params);
        setOnTouchListener((view, motionEvent) -> {
            if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                isOn = !isOn;
                animateSwitch();
            }
            return false;
        });
    }

    private void animateSwitch() {
        if (animator != null) {
            animator.cancel();
        }

        animator = ValueAnimator.ofInt(
                x,
                isOn ? width - 10 - radius : 10 + radius
        );

        animator.setDuration(300);
        animator.start();
        animator.addUpdateListener((anim) -> {
            this.x = (int)anim.getAnimatedValue();
            invalidate();
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.reset();
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        canvas.drawRoundRect(10, 10, width - 10, height - 10, radius, radius, paint);

        paint.reset();
        paint.setColor(Color.CYAN);
        canvas.drawCircle(x, 10 + radius,  radius, paint);
    }

    public boolean isOn() {
        return isOn;
    }
}
