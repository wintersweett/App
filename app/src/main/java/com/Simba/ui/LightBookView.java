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

import com.example.think.myapp.R;

public class LightBookView extends View {
    Paint paint;
    Bitmap dst,src;
    public LightBookView(Context context) {
        super(context);
        paint=new Paint();
        dst= BitmapFactory.decodeResource(getResources(), R.drawable.book_bg);
        src=BitmapFactory.decodeResource(getResources(),R.drawable.book_light);
    }

    public LightBookView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public LightBookView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public LightBookView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dst,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.LIGHTEN));
        canvas.drawBitmap(src,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(id);
    }
}
