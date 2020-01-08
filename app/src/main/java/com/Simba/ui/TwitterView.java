package com.Simba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.graphics.Xfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.think.myapp.R;

public class TwitterView extends View {
    Paint mPaint;
    Bitmap dst;
    Bitmap src;
    public TwitterView(Context context) {
        super(context);
        setLayerType(View.LAYER_TYPE_HARDWARE,null);
        mPaint=new Paint();
        dst= BitmapFactory.decodeResource(getResources(), R.drawable.twiter_bg);
        src=BitmapFactory.decodeResource(getResources(),R.drawable.twiter_light);

    }

    public TwitterView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public TwitterView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public TwitterView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id=canvas.saveLayer(0,0,getWidth(),getHeight(),mPaint,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dst,0,0,mPaint);
        mPaint.setXfermode(new PorterDuffXfermode(Mode.MULTIPLY));
        canvas.drawBitmap(src,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(id);

    }
}
