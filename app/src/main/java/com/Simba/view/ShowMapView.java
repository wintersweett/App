package com.Simba.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Paint.Style;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.Simba.Utils.MapUtils;
import com.example.think.myapp.R;

import static com.Simba.Utils.MapUtils.map;
import static com.Simba.Utils.MapUtils.touchFlag;

public class ShowMapView extends View {
    public ShowMapView(Context context) {
        super(context);
    }

    public ShowMapView(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public ShowMapView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public ShowMapView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        float x=event.getX();
        float y=event.getY();
        ////每格地图大小为80*80,注意:数组和屏幕坐标X和Y相反
        int row= (int) (y/80);
        int col= (int) (x/80);
        if (map[row][col] == 0) {
            touchFlag++;
            if (touchFlag == 1) {
                MapUtils.startRow = row;
                MapUtils.startCol = col;
                map[row][col] = 2;
            } else if (touchFlag == 2) {
                MapUtils.endRow = row;
                MapUtils.endCol = col;
                map[row][col] = 2;
            }
        }
        this.invalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint=new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.BLUE);
        paint.setStyle(Style.STROKE);
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                if (map[i][j]==0) {
                    Bitmap bitmap= BitmapFactory.decodeResource(getResources(), R.drawable.route);
                    canvas.drawBitmap(bitmap,j*80,i*80,paint);
                } else if (map[i][j]==1) {
                    Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.wall);
                    canvas.drawBitmap(bitmap,j*80,i*80,paint);
                } else if (map[i][j]==2) {
                    Bitmap bitmap=BitmapFactory.decodeResource(getResources(),R.drawable.path);
                    canvas.drawBitmap(bitmap,j*80,i*80,paint);
                }
            }
        }
        if (MapUtils.path!=null) {
            canvas.drawPath(MapUtils.path,paint);
        }


    }
}
