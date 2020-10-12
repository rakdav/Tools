package com.example.tools;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.view.View;

public class MyDraw extends View {
    public MyDraw(Context context) {
        super(context);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setColor(Color.RED);
        paint.setSubpixelText(true);
        paint.setAntiAlias(true);
        canvas.drawPaint(paint);
        paint.setColor(Color.BLUE);
        canvas.drawCircle(getWidth()/2,getHeight()/2,50,paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(10,10,30,30,paint);
        String str="Fumishin terrorist";
        Rect rect=new Rect();
        paint.getTextBounds(str,0,str.length(),rect);
        canvas.rotate(-45,rect.exactCenterX(),rect.exactCenterY());

        canvas.drawText(str,50,250,paint);
    }
}
