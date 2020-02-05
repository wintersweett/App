package com.Simba.Utils;

public class SquareUp {
    public void test() {
        squareUp(array);
        for (int i=0;i<array.length;i++) {
            for (int j=0;j<array.length;j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
    }

    public static int n=5;
    public static int[][] array=new int[n][n];
    public static void squareUp(int[][]array) {
        int x=1;//要填入的数据
        //定义起始位置
        int row=0;
        int col=n/2;
        array[row][col]=1;
        //
        while (x < n * n) {
            //在选择下一个位置的时候，先记录现在的位置
            int tempRow=row;
            int tempCol=col;
            //向右上移动
            row--;
            if (row<0) {
                row=n-1;
            }
            col++;
            if (col == n) {
                col=0;
            }
            x++;
            if (array[row][col] == 0) {
                array[row][col] = x;
            } else {
                //如果右上已经填入，就放到当前位置的下面
                //还原
                row=tempRow;
                col=tempCol;
                row++;
                array[row][col]=x;


            }

        }


    }

}
