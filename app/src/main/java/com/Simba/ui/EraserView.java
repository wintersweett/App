package com.Simba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.Simba.Utils.UtilsLog;
import com.example.think.myapp.R;

public class EraserView extends View {
    Paint paint;
    Bitmap bitmapSrc;
    Bitmap bitDst;
    Float preX,preY;
    Float endX,endY;
    Path path;
    public EraserView(Context context) {
        super(context);
        initData();
    }

    private void initData() {
        paint=new Paint();
        bitmapSrc= BitmapFactory.decodeResource(getResources(), R.drawable.xyjy3);
        bitDst=Bitmap.createBitmap(bitmapSrc.getWidth(),bitmapSrc.getHeight(), Config.ARGB_8888);
        path=new Path();
    }

    public EraserView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public EraserView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        UtilsLog.log("zhm","saveCount="+canvas.getSaveCount());
        Canvas canvas1=new Canvas(bitDst);
        canvas1.drawPath(path,paint);
        canvas.drawBitmap(bitDst,0,0,paint);
        paint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
        canvas.drawBitmap(bitmapSrc,0,0,paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
        UtilsLog.log("zhm","saveCount="+canvas.getSaveCount());


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(),event.getY());
                preX=event.getX();
                preY=event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                endX=(preX+event.getX())/2;
                endY=(preY+event.getY())/2;
                path.quadTo(preX,preY,endX,endY);
                preX=event.getX();
                preY=event.getY();
        }
        postInvalidate();
        return super.onTouchEvent(event);

    }
}
