package com.Simba.ui;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Bitmap.Config;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.graphics.Path;
import android.graphics.PorterDuff.Mode;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.Simba.Utils.UtilsLog;
import com.example.think.myapp.R;
/*
将奖品层作为最底层
将覆盖层盖到上面
将path与覆盖层交汇地方out，漏出奖品层
 */

public class GuaGuaCardView extends View {
    Bitmap bitmapText;
    Bitmap bitmapCard;
    Paint mPaint;
    Bitmap bitmap;
    Path mPath;
    Float preX,preY;
    Float endX,endY;



    public GuaGuaCardView(Context context) {
        super(context);
        initData();
    }

    private void initData() {
        setLayerType(View.LAYER_TYPE_SOFTWARE,null);
        mPaint=new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Style.FILL_AND_STROKE);
        mPaint.setStrokeWidth(55);

        bitmapText=BitmapFactory.decodeResource(getResources(),R.drawable.guaguaka_text1);
        bitmapCard=BitmapFactory.decodeResource(getResources(),R.drawable.guaguaka);
        bitmap=Bitmap.createBitmap(bitmapCard.getWidth(),bitmapCard.getHeight(), Config.ARGB_8888);
        mPath=new Path();

    }

    public GuaGuaCardView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public GuaGuaCardView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public GuaGuaCardView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        UtilsLog.log("zhm","onDraw");
        canvas.drawBitmap(bitmapText,0,0,mPaint);
        int layerId=canvas.saveLayer(0,0,getWidth(),getHeight(),null,Canvas.ALL_SAVE_FLAG);
        //先把手指轨迹画到目标Bitmap上
        Canvas canvas1=new Canvas(bitmap);
        canvas1.drawPath(mPath,mPaint);
        //然后把目标图像画到画布上
        canvas.drawBitmap(bitmap,0,0,mPaint);
        //计算源tuxiang区域
        mPaint.setXfermode(new PorterDuffXfermode(Mode.SRC_OUT));
        canvas.drawBitmap(bitmapCard,0,0,mPaint);
        mPaint.setXfermode(null);
        canvas.restoreToCount(layerId);


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()) {
            case MotionEvent.ACTION_DOWN:
                UtilsLog.log("zhm","down==");
                mPath.moveTo(event.getX(),event.getY());
                preX=event.getX();
                preY=event.getY();
                UtilsLog.log("zhm","preX="+preX+"preY="+preY);
                return true;
            case MotionEvent.ACTION_MOVE:
                UtilsLog.log("zhm","move");
                endX=(preX+event.getX())/2;
                endY=(preY+event.getY())/2;
                mPath.quadTo(preX,preY,endX,endY);
                preX=event.getX();
                preY=event.getY();
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }
}
