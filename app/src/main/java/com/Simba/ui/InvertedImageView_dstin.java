package com.Simba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.think.myapp.R;
/*
倒影
 */

public class InvertedImageView_dstin extends View {
    Paint paint;
    Bitmap dst;
    Bitmap src;
    Bitmap invert;
    public InvertedImageView_dstin(Context context) {
        super(context);
        paint=new Paint();
        dst= BitmapFactory.decodeResource(getResources(), R.drawable.xyjy6);
        src=BitmapFactory.decodeResource(getResources(),R.drawable.invert_shade);
        Matrix matrix=new Matrix();
        matrix.setScale(1F,-1F);
        invert=Bitmap.createBitmap(dst,0,0,dst.getWidth(),dst.getHeight(),matrix,true);

    }

    public InvertedImageView_dstin(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InvertedImageView_dstin(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public InvertedImageView_dstin(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(dst,0,0,paint);
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,src.getHeight());
        canvas.drawBitmap(invert,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.DST_IN));
        canvas.drawBitmap(src,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
