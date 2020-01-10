package com.Simba.activity;

import android.content.ComponentName;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.UserHandle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;

import com.Simba.Utils.Astar;
import com.Simba.Utils.MapUtils;
import com.Simba.Utils.UtilsLog;
import com.Simba.entity.MapInfo;
import com.Simba.entity.Node;
import com.Simba.view.ShowMapView;
import com.example.think.myapp.R;

import static com.Simba.Utils.MapUtils.endCol;
import static com.Simba.Utils.MapUtils.endRow;
import static com.Simba.Utils.MapUtils.map;
import static com.Simba.Utils.MapUtils.result;
import static com.Simba.Utils.MapUtils.startCol;
import static com.Simba.Utils.MapUtils.startRow;
import static com.Simba.Utils.MapUtils.touchFlag;
/*
启发式寻路算法的地图
 */

public class MapSuanfaActivity extends AppCompatActivity implements OnClickListener {
Button bt_cal,bt_del;
ShowMapView mapView;
Handler handler=null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        handler=new Handler(Looper.getMainLooper());

        setContentView(R.layout.activity_map_suanfa);
        view();
        registerListener();
    }
    public void cal(View view) {
        UtilsLog.i("zhm","map[0].length"+map[0].length+"==map.length=="+map.length);
        MapInfo info=new MapInfo(map,map[0].length,map.length,new Node(startCol,startRow),new Node(endCol,endRow));
        new Astar().start(info);
        new MoveThread((ShowMapView) mapView).start();
    }
    public void reset(View view) {
        MapUtils.path=null;
        MapUtils.result.clear();
        touchFlag=0;
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                if (map[i][j]==2) {
                    map[i][j]=0;
                }
            }
        }
        mapView.invalidate();

    }

    private void registerListener() {
        bt_del.setOnClickListener(this);
        bt_cal.setOnClickListener(this);
    }

    private void view() {
        mapView=(ShowMapView)findViewById(R.id.smv) ;
        bt_cal=(Button)findViewById(R.id.bt_cal);
        bt_del=(Button)findViewById(R.id.bt_del);

    }

    @Override
    public synchronized ComponentName startForegroundServiceAsUser(Intent service, UserHandle user) {
        return null;
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.bt_cal:
                cal(mapView);
                break;
            case R.id.bt_del:
                reset(mapView);
                break;
        }

    }

    class MoveThread extends Thread {
        ShowMapView mapView;
        public MoveThread(ShowMapView mapView) {
            this.mapView=mapView;
        }

        @Override
        public void run() {
            super.run();
            while (result.size() > 0) {
                Node node=result.pop();
                UtilsLog.i("zhm","result.size=="+result.size()+"==x=="+node.coord.x+"==y=="+node.coord.y);
                map[node.coord.y][node.coord.x]=2;
                handler.post(new Runnable() {
                    @Override
                    public void run() {
                        mapView.invalidate();
                    }
                });
                try {
                    Thread.sleep(300);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                map[node.coord.y][node.coord.x]=0;
            }
            MapUtils.touchFlag=0;
        }
    }
}
