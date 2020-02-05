package com.Simba.Utils;

import java.util.LinkedList;

public class Graph {
    private int[]vertices;//顶点集
    public int[][] matrix;//图的边的信息
    private  int verticesSize;
    public static final int MAX_WEIGHT=Integer.MAX_VALUE;
    public boolean[] isVisited;//是否被访问过

    public Graph(int verticesSize) {
        this.verticesSize=verticesSize;
        vertices=new int[verticesSize];
        isVisited=new boolean[verticesSize];
        matrix=new int[verticesSize][verticesSize];
        for (int i=0;i<verticesSize;i++) {
            vertices[i]=i;

        }
    }


    /**
     * 计算v1到v2的权重（路径长度）
     */
    public int getWeight(int v1,int v2) {
        int weight=matrix[v1][v2];
        return weight==0?0:(weight==MAX_WEIGHT?-1:weight);

    }
    /**
     * 获取顶点
     */
    public int[] getVertices() {
        return vertices;
    }

    /**
     * 获取出度
     */
    public int getOUtDegree(int v) {
        int count=0;
        for (int i=0;i<verticesSize;i++) {
            if (matrix[v][i]!=0 && matrix[v][i]!=MAX_WEIGHT) {
                count++;
            }
        }
        return count;
    }
    //获取入度
    public int getInDegree(int v) {
        int count=0;
        for (int i=0;i<verticesSize;i++) {
            if (matrix[i][v]!=0 && matrix[i][v]!=MAX_WEIGHT) {
                count++;
            }
        }
        return count;
    }
    //创建矩阵
    public void creatSimpleMatrix() {
        int[]a0={0,1,1,MAX_WEIGHT,MAX_WEIGHT};
        int[]a1={MAX_WEIGHT,0,MAX_WEIGHT,1,MAX_WEIGHT};
        int[]a2={MAX_WEIGHT,MAX_WEIGHT,0,MAX_WEIGHT,MAX_WEIGHT};
        int[]a3={1,MAX_WEIGHT,MAX_WEIGHT,0,MAX_WEIGHT};
        int[]a4={MAX_WEIGHT,MAX_WEIGHT,1,MAX_WEIGHT,0};
        matrix[0]=a0;
        matrix[1]=a1;
        matrix[2]=a2;
        matrix[3]=a3;
        matrix[4]=a4;

    }

    /**
     * 获取第一个邻接点
     */


    public int getFirstNeightbor(int v) {
        for (int i=0;i<verticesSize;i++) {
            if (matrix[v][i]!=0 && matrix[v][i] !=MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }

    /**
     * 获取到顶点v的邻接点index的下一个邻接点
     */
    public int getNextNeightbor(int v,int index) {
        for (int i=index+1;i<verticesSize;i++) {
            if (matrix[v][i]>0 && matrix[v][i]!=MAX_WEIGHT) {
                return i;
            }
        }
        return -1;
    }


    /**
     * 深度优先
     */
    public void dfs() {
        for (int i=0;i<verticesSize;i++) {
            if (!isVisited[i]) {
                System.out.println("visit vertice"+i);
                dfs(i);
            }
        }
    }

    public void dfs(int i) {
        isVisited[i]=true;
        int v=getFirstNeightbor(i);
        while (v != -1) {
            if (!isVisited[v]) {
                System.out.println("visit vertice"+v);
                dfs(v);
            }
            v=getNextNeightbor(i,v);
        }



    }


    /**
     * 广度优先遍历
     *
     */

    public void bfs() {
        for (int i = 0; i < verticesSize; i++) {
           isVisited[i]=false;
        }
        for (int i=0;i<verticesSize;i++) {
            if (!isVisited[i]) {
                isVisited[i]=true;
                System.out.println("visit vertices "+i);
                bfs(i);
            }
        }
    }
    public void bfs(int i) {
        java.util.LinkedList<Integer> queque=new LinkedList<>();
        //找第一个邻接点
        int fn=getFirstNeightbor(i);
        if (fn==-1) {
            return;
        }
        if (!isVisited[fn]) {
            isVisited[fn]=true;
            System.out.println("visit vertices"+fn);
            queque.offer(fn);
        }
        //把后面的邻接点都入队
        int next=getNextNeightbor(i,fn);
        while (next != -1) {
            if (!isVisited[next]) {
                isVisited[next]=true;
                System.out.println("visit vertices "+next);
                queque.offer(next);
            }
            next=getNextNeightbor(i,next);
        }

        //从队列中取出一个，重复之前的操作
        while (!queque.isEmpty()) {
            int point=queque.poll();
            bfs(point);
        }

    }




}

