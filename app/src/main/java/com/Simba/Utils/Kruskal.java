package com.Simba.Utils;

public class Kruskal {

    public int verticeSize;
    public int[][]vertices;
    public int[][]matrix;
    public int edgeSize;
    public static final int MAX_WEIGHT=0xff8;
    public Edge[] edges;
    public Kruskal(int verticeSize) {
        this.verticeSize=verticeSize;
        matrix=new int[verticeSize][verticeSize];
    }
    //获取所有的边
    private Edge[]getEdges() {
        int index=0;
        Edge[]edges=new Edge[verticeSize*verticeSize];
        for (int i=0;i<verticeSize;i++) {
            for (int j=0;j<verticeSize;j++) {
                if (matrix[i][j]!=0 && matrix[i][j]!=MAX_WEIGHT) {
                    edges[index++]=new Edge(i,j,matrix[i][j]);
                }
            }
        }
        edgeSize=index;
        return edges;
    }
    public  void sortEdge(Edge[]cur_edge,int size) {
        for (int i=0;i<size;i++) {
            for (int j=i+1;j<size;j++) {
                if (edges[i].weight>edges[j].weight) {
                    Edge tmp=edges[i];
                    edges[i]=edges[j];
                    edges[j]=tmp;
                }
            }
        }
    }

    //核心算法
    public void kruskal() {
        edges=getEdges();
        int index=0;
        Edge[] cur_edge=edges;
        Edge[] rets=new Edge[edgeSize];
        sortEdge(cur_edge,edgeSize);
        int[] edge_temp=new int[edgeSize];
        for (int i=0;i<edgeSize;i++) {
            int p1=cur_edge[i].start;
            int p2=cur_edge[i].end;
            int m=getEnd(edge_temp,p1);
            int n=getEnd(edge_temp,p2);
            if (m!=n) {
                rets[index++]=cur_edge[i];
                if (m>n) {
                    int temp=n;
                    n=m;m=temp;
                }
                edge_temp[m]=n;
            }
        }
        int length=0;
        for (int i=0;i<index;i++) {
            length+=rets[i].weight;
        }
        System.out.println("最小生成树权重之和"+length);
        Character[] chars=new Character[verticeSize];
        chars[0]='A';
        chars[1]='B';
        chars[2]='C';
        chars[3]='D';
        chars[4]='E';
        chars[5]='F';
        chars[6]='G';
        for (int i=0;i<index;i++) {
        }
    }
    private int getEnd(int[]edge_temp,int p) {
        int i=p;
        while (edge_temp[i] != 0) {
            i=edge_temp[i];
        }
        return i;
    }


    public static class Edge {
        int start;
        int end;
        int weight;
        public Edge(int start,int end,int weight) {
            this.start=start;
            this.end=end;
            this.weight=weight;
        }
    }


}
