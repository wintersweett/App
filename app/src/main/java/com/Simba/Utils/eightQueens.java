package com.Simba.Utils;

public class eightQueens {
    //下标表示行号 值表示列号
    public static int[]array=new int[8];
    //处理八个皇后的问题
    public static void eightQueens(int row) {
        //如果有结果了就退出了
        if (row==8) {
            printResult();
            return;
        }
       //开始从第一列到自后一列一个个放入
        for (int col=0;col<8;col++) {
            array[row]=col;
            if (judge(row)) {
                eightQueens(row+1);
            }
        }
    }
    //判断当前列放入的位置 是否和以前放入过的内容有冲突
    public static boolean judge(int n) {
        for (int i=0;i<n;i++) {
            //1 array[i]==array[n] 在一列上
            //2、abs(n-i)==abs(array[i]-array[n]) 在对角线上
            if (array[i]==array[n]|| Math.abs(n-i)==Math.abs(array[i]-array[n])) {
                return false;
            }

        }

        return true;
    }

    public static void printResult() {
        for (int i=0;i<array.length;i++) {
            System.out.print(array[i]+" ");
        }
        System.out.println("-------------");
    }

}
