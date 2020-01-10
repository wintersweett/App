package com.Simba.entity;

import com.Simba.Utils.UtilsLog;

public class MapInfo {
    public int[][]map;//二维数组的地图
    public int width;//地图的宽
    public int height;//地图的高
    public Node start;//起始节点
    public Node end;//终止节点
    public MapInfo(int[][]map,int width,int height,Node start,Node end) {
        this.map=map;
        this.width=width;
        this.height=height;
        this.start=start;
        this.end=end;
        UtilsLog.i("zhm","地图启动");
    }
}
