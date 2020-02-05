package com.Simba.Utils;

/**
 * 图论：弗洛伊德算法
 */

public class Floyd {
    public static final int I=100;
    //邻接矩阵
    public static int[][] d=new int[][]{
            {0,2,1,5},
            {2,0,4,I},
            {1,4,0,3},
            {5,I,3,0}
    };

    public static int[][] p=new int[][]{
            {0,1,2,3},
            {0,1,2,3},
            {0,1,2,3},
            {0,1,2,3}
    };
    public static void floyd() {
        for (int k=0;k<d.length;k++) {
            for (int i=0;i<d.length;i++) {
                for (int j=0;j<d.length;j++) {
                    if (d[i][j]>d[i][k]+d[k][j]) {
                        d[i][j]=d[i][k]+d[k][j];
                        //记录下路径
                        p[i][j]=p[i][k];
                    }
                }
            }
        }
    }

    public static void printShortPath() {
        for (int i=0;i<d.length;i++) {
            for (int j=0;j<d.length;j++) {
                System.out.println("V"+i+"->V"+j+" weight:"+d[i][j]+" path:"+i);
                int k=p[i][j];
                while (k != j) {
                    System.out.println("->"+k);
                    k=p[k][j];
                }
                System.out.println();
            }
        }
    }

}
