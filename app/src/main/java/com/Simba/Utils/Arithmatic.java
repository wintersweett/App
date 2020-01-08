package com.Simba.Utils;

import com.Simba.entity.Mahjong;

import java.util.LinkedList;

public class Arithmatic {

    /**
     * 汉诺塔：一次移动一个，大的只能在小的下面
     * @param n   盘子个数
     * @param start 开始的柱子： 第一个柱子1
     * @param middle  中介的柱子2
     * @param end  放结果的柱子3
     */
    public static void hanoi(int n,int start,int middle,int end) {
        if (n <= 1) {
            System.out.println(start + "-->" + end);//直接从1移到3
        } else {
            hanoi(n-1,start,end,middle);//将除最底下的一个盘子以外的所有盘子，通过end中介，移到middle
            System.out.println(start+"-->"+end);
            hanoi(n-1,middle,start,end);
        }

    }
    //斐波那契数：从第三项开始，每一项等于前两项之和1 1 2 3 5 8 13 21 34 55 89……,求第n项
    public static int fibonacci(int n) {
        if (n == 1 || n == 2) {
            return 1;
        } else {
            return fibonacci(n-1)+fibonacci(n-2);
        }
    }

    //阶乘的计算
    public static int  factorial(int n) {
        if (n == 1) {
            return 1;
        } else {
            return n*factorial(n-1);
        }
    }
    //递归
    public static void func(int n) {
       System.out.println(n);
        if (n < 0) {
            return;
        } else {
            func(n-1);//递归调用自己后的所有代码都会压入一个栈
            System.out.println(n);
        }
    }


    /*
    冒泡排序：从小到大
     */
    public static int[] bubbleSort(int[]array) {
        for (int i=array.length-1;i>0;i--) {
            boolean flag=true;
            for (int j=0;j<i;j++) {
                if (array[j]>array[j+1]) {
                    int temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                    flag=false;
                }
            }
            if (flag) {
                break;
            }

        }

return array;
    }


    /*
    选择排序/
     */
        public static void selectSort(int[] array){
            //2,1,5,3,4
            for(int i=0;i<array.length-1;i++) {
                UtilsLog.log("zhm","==i=="+i);

                int index = i;
                for (int j = i+1; j < array.length; j++) {
                    UtilsLog.log("zhm","j=="+j);
                    if (array[j] < array[index]) {
                        index = j;
                        UtilsLog.log("zhm","index=="+index+"==j=="+j+"==i=="+i);
                    }
                }
                if(index!=i) {//如果已经是最小的，就不需要交换
                    UtilsLog.log("zhm","exchange");
                    int temp = array[index];
                    array[index] = array[i];
                    array[i] = temp;
                }


            }
        }


    /*
     交换
    可读性与性能
     */
    public static void exchange() {
        int a=5;
        int b=10;
        //可读性好
       /* int temp=a;
        a=b;
        b=temp;*/

       //性能好,但没有可读性，如无人机、跑步
        a=a^b;
        b=a^b;
        a=a^b;


    }
    /*
     如麻将
     */
    public static void singleLinkedListSort(LinkedList<Mahjong>list) {
        //先对点数进行分组
        LinkedList[] rankList=new LinkedList[9];
        for (int i=0;i<rankList.length;i++) {
            rankList[i]=new LinkedList();
        }
        //把数据一个个放到对应的组中
        while (list.size() > 0) {
            //取一个
            Mahjong m=list.remove();
            //放到组中
            rankList[m.rank-1].add(m);

        }
        //把九组合并在一起
        for (int i=0;i<rankList.length;i++) {
            list.addAll(rankList[i]);
        }

        //sencond time:花色分组
        LinkedList[] suitList=new LinkedList[3];
        for (int i=0;i<suitList.length;i++) {
            suitList[i]=new LinkedList();

        }
        while (list.size() > 0) {
            Mahjong n=list.remove();
            suitList[n.suit-1].add(n);
        }
        for (int i=0;i<suitList.length;i++) {
            list.addAll(suitList[i]);
        }


    }
    /*
    二分查找（前提是有序）
     */

    public static int binarySort(int[] array,int beginIndex,int endIndex,int key) {
        int low=beginIndex;
        int high=endIndex-1;//【），左闭右开
        while (low <= high) {
            int mid=(low+high)/2;
            int midVal=array[mid];
            if (key<midVal) {//左边
                high=mid-1;
            } else if (key > midVal) {
                low = mid + 1;
            } else {
                return mid;
            }

        }

       return -1;
    }

    /*
    快速排序，
    api中Arrays.sort()可以实现快排，但是代码行数太多，不简便，相当于前序DLR
    适合大量非重复数据
     */
    public static void quickSort(int[]array,int begin,int end) {
        if (end-begin<=0) {
            return;//防止乱输入
        }
        int x=array[begin];//拿出第一个数当作比较数
        int low=begin;
        int high=end;
        boolean direction=true;//由于会从两头取数据，需要一个方向
        L1:
        while (low < high) {
            if (direction) {//从右往左找
                for (int i=high;i>low;i--) {
                    if (array[i]<=x) {
                        array[low++]=array[i];
                        high=i;
                        direction=!direction;
                        continue L1;
                    }

                }
                high=low;//如果未进入if，让两个指针重合
            } else {
                for (int i=low;i<high;i++) {
                    if (array[i]>=x) {
                        array[high--]=array[i];
                        low=i;
                        direction=!direction;
                        continue L1;

                    }
                }
                low=high;
            }
        }
array[low]=x;//把最后找到的值放入中间位置
        quickSort(array,begin,low-1);
        quickSort(array,low+1,end);



    }

    /*
    归并排序，===二叉树的后序LRD；
    适合大量数据
    由于创建了很多数组，拿空间换时间
     */
    public static void mergeSort(int[]array,int left,int right) {
        if (left == right) {
            return;
        } else {
            int mid=(left+right)/2;
            mergeSort(array,left,mid);
            mergeSort(array,mid+1,right);
            merge(array,mid+1,left,right);
        }


    }
//将两个有序数组合并
    private static void merge(int[] array, int mid ,int left, int right) {
        int leftSize=mid-left;
        int rightSize=right-mid+1;
        //生成数组
        int[]leftArray=new int[leftSize];
        int[]rightArray=new int[rightSize];
        //填充数据
        for (int i=left;i<mid;i++) {
            leftArray[i-left]=array[i];
        }
        for (int i=mid;i<=right;i++) {
            rightArray[i-mid]=array[i];
        }
        //合并
        int i=0;
        int j=0;
        int k=left;
        while (i < leftSize && j < rightSize) {
            if (leftArray[i] < rightArray[j]) {
                array[k] = leftArray[i];
                k++;
                i++;
            } else {
                array[k]=rightArray[j];
                k++;j++;
            }
        }
        while (i < leftSize) {
            array[k]=leftArray[i];
            k++;i++;
        }
        while (j < rightSize) {
            array[k]=rightArray[j];
            k++;j++;
        }

    }




}
