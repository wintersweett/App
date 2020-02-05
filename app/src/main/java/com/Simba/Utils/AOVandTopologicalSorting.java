package com.Simba.Utils;

/**
 * AOV网络与拓扑排序
 */

public class AOVandTopologicalSorting {
    VertexNode[] graphAdjList=new VertexNode[15];
    //建一个表
    public void creatSheet() {
        EdgeNode a=new EdgeNode(3,null);
        EdgeNode a2=new EdgeNode(2,a);
        EdgeNode a3=new EdgeNode(1,a2);
        graphAdjList[0]=new VertexNode(0,1,a3);
        graphAdjList[1]=new VertexNode(2,2,null);
        EdgeNode b1=new EdgeNode(9,null);
        EdgeNode b2=new EdgeNode(8,b1);
        EdgeNode b3=new EdgeNode(6,b2);
        EdgeNode b4=new EdgeNode(5,b3);
        graphAdjList[2]=new VertexNode(2,3,b4);
        EdgeNode c1=new EdgeNode(7,null);
        EdgeNode c2=new EdgeNode(9,c1);
        EdgeNode c3=new EdgeNode(6,c2);
        graphAdjList[3]=new VertexNode(2,4,c3);
        graphAdjList[4]=new VertexNode(1,5,null);
        graphAdjList[5]=new VertexNode(1,6,null);
        graphAdjList[6]=new VertexNode(3,7,null);
        graphAdjList[7]=new VertexNode(1,8,null);
        graphAdjList[8]=new VertexNode(1,9,null);
        EdgeNode d1=new EdgeNode(10,null);
        EdgeNode d2=new EdgeNode(6,d1);
        graphAdjList[9]=new VertexNode(2,10,d2);
        EdgeNode e1=new EdgeNode(11,null);
        graphAdjList[10]=new VertexNode(1,11,e1);
        graphAdjList[11]=new VertexNode(1,12,null);
        EdgeNode f1=new EdgeNode(3,null);
        EdgeNode f2=new EdgeNode(13,f1);
        graphAdjList[12]=new VertexNode(0,13,f2);
        EdgeNode g1=new EdgeNode(14,null);
        EdgeNode g2=new EdgeNode(1,g1);
        EdgeNode g3=new EdgeNode(2,g2);
        graphAdjList[13]=new VertexNode(1,14,g3);
        EdgeNode h1=new EdgeNode(4,null);
        graphAdjList[14]=new VertexNode(1,15,h1);
       topologicalSort();

    }
    //拓扑排序
    public void topologicalSort() {
        int top=0;//栈顶指针
        int[]stack=new int[15];//
        for (int i=0;i<graphAdjList.length;i++) {
            if (graphAdjList[i].in==0) {
                stack[++top]=i;
            }
        }

        //开始算法的逻辑
        while (top != 0) {
            int getTop=stack[top--];
            System.out.println(" "+graphAdjList[getTop].data);
            //更新当前输出结点所有的出边
            for (EdgeNode e=graphAdjList[getTop].first;e!=null;e=e.next) {
                int k=e.data;
                graphAdjList[k].in--;
                if (graphAdjList[k].in==0) {
                    stack[++top]=k;
                }
            }
        }
    }






    //边表结点
    class EdgeNode{
        int data;
        EdgeNode next;
        public EdgeNode(int data,EdgeNode next) {
            this.data=data;
            this.next=next;

        }
    }

    //顶点表结点
    class VertexNode{
        int in;//入度
        int data;
        EdgeNode first;
        public VertexNode(int in,int data,EdgeNode first) {
            this.in=in;
            this.data=data;
            this.first=first;
        }
    }
}
