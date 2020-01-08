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

public class InvertedImageView_SRCATOP extends View {
    Paint paint;
    Bitmap dst,src,revert;
    public InvertedImageView_SRCATOP(Context context) {
        super(context);
        paint=new Paint();
        dst= BitmapFactory.decodeResource(getResources(), R.drawable.invert_shade);
        src=BitmapFactory.decodeResource(getResources(),R.drawable.xyjy6);
        Matrix matrix=new Matrix();
        matrix.setScale(1F,-1F);
        revert=Bitmap.createBitmap(src,0,0,src.getWidth(),src.getHeight(),matrix,true);
    }

    public InvertedImageView_SRCATOP(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public InvertedImageView_SRCATOP(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public InvertedImageView_SRCATOP(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(src,0,0,paint);
        int id=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.translate(0,src.getHeight());

        canvas.drawBitmap(dst,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_ATOP));
        canvas.drawBitmap(revert,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(id);
    }
}
