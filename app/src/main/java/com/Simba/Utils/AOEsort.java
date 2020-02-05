package com.Simba.Utils;

/***
 * 也就是带权重的AOV
 */

public class AOEsort {
    VertexNode[] graphAdjList=new VertexNode[9];
    int[]etv=new int[9];
    int[]ltv=new int[9];
    int[]ete=new int[9];
    int[]lte=new int[9];

    int[]stack2=new int[9];
    int top2=0;




    public void creatAOE() {
        EdgeNode a=new EdgeNode(3,5,null);
        EdgeNode a2 = new EdgeNode(2, 4, a);
        EdgeNode a3 = new EdgeNode(1, 6, a2);
        graphAdjList[0] = new VertexNode(0, 1, a3);

        EdgeNode b1 = new EdgeNode(4, 1, null);
        graphAdjList[1] = new VertexNode(1, 2, b1);

        EdgeNode c1 = new EdgeNode(4, 1, null);
        graphAdjList[2] = new VertexNode(1, 3, c1);

        EdgeNode d1 = new EdgeNode(5, 2, null);
        graphAdjList[3] = new VertexNode(1, 4, d1);

        EdgeNode e1 = new EdgeNode(7, 5, null);
        EdgeNode e2 = new EdgeNode(6, 7, e1);
        graphAdjList[4] = new VertexNode(2, 5, e2);

        EdgeNode f2 = new EdgeNode(7, 4, null);
        graphAdjList[5] = new VertexNode(1, 6, f2);

        EdgeNode f3 = new EdgeNode(8, 2, null);
        graphAdjList[6] = new VertexNode(1, 7, f3);

        EdgeNode f4 = new EdgeNode(8, 4, null);
        graphAdjList[7] = new VertexNode(2, 8, f4);

        graphAdjList[8] = new VertexNode(2, 9, null);
        criticalPath();

    }

    //拓扑排序
    public void topologicalSort() {
        int top=0;
        int[]stack=new int[9];
        for (int i=0;i<graphAdjList.length;i++) {
            if (graphAdjList[i].in==0) {
                stack[++top]=i;
            }
        }
        //开始算法的逻辑
        while (top != 0) {
            int getTop=stack[top--];
            //保存拓扑排序顺序
            stack2[top2++]=getTop;
            for (EdgeNode e=graphAdjList[getTop].first;e!=null;e=e.next) {
                int k=e.data;
                graphAdjList[k].in--;
                if (graphAdjList[k].in==0) {
                    stack[++top]=k;
                }
//计算顶点的最早开始时间
                if ((etv[getTop]+e.weight)>etv[k]) {
                    etv[k]=etv[getTop]+e.weight;
                }
            }
        }

    }

    public void criticalPath() {
        topologicalSort();
        //初始化ltv都为汇点时间
        for (int i=0;i<9;i++) {
            ltv[i]=etv[8];
        }
        //从汇点开始倒过来计算ltv
        while (top2 > 0) {
            int getTop=stack2[--top2];//从汇点开始
            for (EdgeNode e=graphAdjList[getTop].first;e!=null;e=e.next) {
                int k=e.data;
                if (ltv[k]-e.weight<ltv[getTop]) {
                    ltv[getTop]=ltv[k]-e.weight;
                }
            }
        }
        //通过etv和ltv计算初ete和lte
        for (int i=0;i<9;i++) {
            for (EdgeNode e=graphAdjList[i].first;e!=null;e=e.next) {
                int k=e.data;
                ete[i]=etv[i];
                lte[i]=ltv[k]-e.weight;
                if (ete[i]==lte[i]) {
                    System.out.println(graphAdjList[i].data+" "+graphAdjList[k].data+" "+e.weight);
                }
            }
        }
    }




    //边表结点
    class EdgeNode{
        int data;
        int weight;
        EdgeNode next;
        public EdgeNode(int data,int weight,EdgeNode next) {
            this.data=data;
            this.weight=weight;
            this.next=next;
        }
    }
    //顶点表结点
    class VertexNode{
        int in;
        int data;
        EdgeNode first;
        public VertexNode(int in,int data,EdgeNode first) {
            this.in=in;
            this.data=data;
            this.first=first;
        }

    }
}
