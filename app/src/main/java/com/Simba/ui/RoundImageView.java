package com.Simba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.Simba.Utils.UtilsLog;
import com.example.think.myapp.R;
/*
图形组合出圆角效果
 */


public class RoundImageView extends View {
    Paint paint;
    Bitmap dst,src;
    public RoundImageView(Context context) {
        super(context);
        paint=new Paint();
        dst= BitmapFactory.decodeResource(getResources(), R.drawable.xyjy6);
        src=BitmapFactory.decodeResource(getResources(),R.drawable.shade);
    }

    public RoundImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public RoundImageView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        UtilsLog.log("zhm","layer"+canvas.getSaveCount());
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),paint,Canvas.ALL_SAVE_FLAG);
        UtilsLog.log("zhm","layer"+canvas.getSaveCount());
        canvas.drawBitmap(dst,0,0,paint);
        //可以换不同模式尝试如dst——in，
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(src,0,0,paint);
    }
}
