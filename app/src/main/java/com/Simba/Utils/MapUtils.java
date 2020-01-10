package com.Simba.Utils;

import android.graphics.Path;

import com.Simba.entity.Node;

import java.util.Stack;

public class MapUtils {
    public static int startRow=0;
    public static int startCol=0;
    public static int endRow=0;
    public static int endCol=0;
    public static int touchFlag=0;
    public static Stack<Node> result=new Stack<>();
    public static Path path;
    public final static int WALL=1;//障碍
    public final static int PATH=2;//路径
    public static int[][] map = {
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
            {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
            {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1},
            {0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
            {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
            {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
            {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
            {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
            {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
            {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0},
            {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
            {1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
            {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1}
    };
    public static int mapRowSize=map.length;
    public static int mapColSize=map[0].length;
    //打印地图
    public static void printMap(int[][]map) {
        for (int i=0;i<map.length;i++) {
            for (int j=0;j<map[i].length;j++) {
                System.out.print(map[i][j]+" ");
            }
            System.out.println();
        }
    }
}
