package com.Simba.entity;


public class Node implements Comparable<Node> {
    public Coord coord;//坐标
    public Node parent;//父节点
    public int g;//是个准确的值，是起点到当前结点的代价
    public int h;//是个估值，当前结点到目的结点的估计代价

    public Node(int x, int y) {
        this.coord = new Coord(x, y);
    }

    public Node(Coord coord,Node parent,int g,int h) {
        this.coord=coord;
        this.parent=parent;
        this.g=g;
        this.h=h;
    }


    @Override

    public int compareTo(Node o) {
        if (o==null) {return -1;
        }
        if (g+h>o.g+o.h) {return 1;
        } else if (g+h<o.g+o.h) {return -1;
        }
        return 0;
    }
}
