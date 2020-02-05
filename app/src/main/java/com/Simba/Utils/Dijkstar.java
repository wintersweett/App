package com.Simba.Utils;

public class Dijkstar {
    public static final int I=100;
    int[][]array=new int[][]{
            {0,1,5,I,I,I,I,I,I},
            {1,0,3,7,5,I,I,I,I},
            {5,3,0,I,1,7,I,I,I},
            {I,7,I,0,2,I,3,I,I},
            {I,5,1,2,0,3,6,I,I},
            {I,I,7,I,3,0,I,5,I},
            {I,I,I,3,6,I,0,2,7},
            {I,I,I,I,9,5,2,0,4},
            {I,I,I,I,I,I,7,4,0}
    };
    public void dijkstar() {
        int k=0;
        int[]path=new int[9];
        int[]weight=array[0];
        int[]flag=new int[9];
        flag[0]=1;

        for (int v=1;v<9;v++) {
            int min=I;
            for (int i=0;i<9;i++) {
                if (flag[i]==0 && weight[i]<min) {
                    k=i;
                    min=weight[i];
                }
            }
            flag[k]=1;
            for (int i=0;i<9;i++) {
                if (flag[i]==0 && (min+array[k][i]<weight[i])) {
                    weight[i]=min+array[k][i];
                    path[i]=k;
                }
            }
        }

        for (int i=0;i<path.length;i++) {
            System.out.println(path[i]+" ");
        }

        int v=8;
        while (v != 0) {
            System.out.println(path[v]);
            v=path[v];
        }
    }
}
