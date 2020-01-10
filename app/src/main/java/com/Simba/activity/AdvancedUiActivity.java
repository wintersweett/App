package com.Simba.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.Simba.ui.DrawingTest;
import com.Simba.ui.EraserView;
import com.Simba.ui.FilterView;
import com.Simba.ui.FilterView2;
import com.Simba.ui.GuaGuaCardView;
import com.Simba.ui.InvertedImageView_SRCATOP;
import com.Simba.ui.InvertedImageView_dstin;
import com.Simba.ui.LightBookView;
import com.Simba.ui.MyGradient;
import com.Simba.ui.RadarGradientView;
import com.Simba.ui.RoundImageView;
import com.Simba.ui.TwitterView;
import com.Simba.ui.ZoomImageView;
import com.example.think.myapp.R;

public class AdvancedUiActivity extends AppCompatActivity {
    String to;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        getData();
        if ("跳转到流式".equals(to)) {
            setContentView(R.layout.waterflow_layout);
        } else if ("线性渲染".equals(to)) {//跳转到渲染
            setContentView(R.layout.activity_advanced_ui);
        } else if ("雷达".equals(to)) {
            setContentView(new RadarGradientView(this));

        } else if ("填满心".equals(to)) {
            setContentView(new MyGradient(this));

        } else if ("水波纹".equals(to)) {
            setContentView(new ZoomImageView(this));
        } else if ("滤镜".equals(to)) {
            setContentView(new FilterView(this));
        } else if ("滤镜2".equals(to)) {
            setContentView(new FilterView2(this));
        } else if ("刮刮卡".equals(to)) {
            setContentView(new GuaGuaCardView(this));
        } else if ("drawingTest".equals(to)) {
            setContentView(new DrawingTest(this));
        } else if ("橡皮擦".equals(to)) {
            setContentView(new EraserView(this));
        } else if ("Mutiply".equals(to)) {
            setContentView(new TwitterView(this));
        } else if ("倒影".equals(to)) {
            setContentView(new InvertedImageView_dstin(this));
        }else if ("2".equals(to)) {
            setContentView(new InvertedImageView_SRCATOP(this));
        }else if ("lighten".equals(to)) {
            setContentView(new LightBookView(this));
        }else if ("圆角".equals(to)) {
            setContentView(new RoundImageView(this));
        } else if ("启发式寻路算法".equals(to)) {
            Intent intent=new Intent(this,MapSuanfaActivity.class);
            startActivity(intent);
        }


    }

    private void getData() {
        Intent intent=getIntent();
        to=intent.getStringExtra("to");
    }
}
