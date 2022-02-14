package com.usu.drawing;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.MotionEvent;
import android.view.View;

import java.util.ArrayList;

public class DrawingView extends View {
    Paint paint = new Paint();
    ArrayList<Shape> shapes = new ArrayList<Shape>();
    public DrawingView(Context context) {
        super(context);
        setOnTouchListener(new OnTouchListener() {

            @Override
            public boolean onTouch(View view, MotionEvent motionEvent) {
                if (motionEvent.getAction() == MotionEvent.ACTION_DOWN) {
                    shapes.add(new Square(100, 100, (int)motionEvent.getX(), (int)motionEvent.getY()));
                }
                return false;
            }
        });
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        canvas.save();
        paint.reset();
        canvas.restore();
    }
}
