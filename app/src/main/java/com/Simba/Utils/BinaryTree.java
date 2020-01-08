package com.Simba.Utils;

public class BinaryTree {
    //节点
    class Node<T> {
        T data;
        Node<T> leftChild;
        Node<T> rightChild;
        public Node(T data,Node<T>leftChild,Node<T>rightChild) {
            this.data=data;
            this.leftChild=leftChild;
            this.rightChild=rightChild;
        }


    }

    Node<String>root;
    public BinaryTree(String data) {
        root=new Node<>(data,null,null);
    }

    //制造二叉树
    public void createTree() {
        Node<String> nodeB=new Node<>("B",null,null);
        Node<String>nodeC=new Node<>("C",null,null);
        Node<String>nodeD=new Node<>("D",null,null);
        Node<String>nodeE=new Node<>("E",null,null);
        Node<String>nodeF=new Node<>("F",null,null);
        Node<String>nodeG=new Node<>("G",null,null);
        Node<String>nodeH=new Node<>("H",null,null);
        Node<String>nodeI=new Node<>("I",null,null);
        Node<String>nodeJ=new Node<>("J",null,null);
        root.leftChild=nodeB;
        root.rightChild=nodeC;
        nodeB.leftChild=nodeD;
        nodeB.rightChild=nodeE;
        nodeD.leftChild=nodeH;
        nodeE.rightChild=nodeI;
        nodeF.leftChild=nodeJ;
        nodeC.leftChild=nodeF;
        nodeC.rightChild=nodeG;



    }
    //中序访问所有节点LDR
    public void midOrderTraverse(Node root) {
        if (root==null) {
            return;
        }
        midOrderTraverse(root.leftChild);
        System.out.println("mid: "+root.data);
        midOrderTraverse(root.rightChild);
    }

    //前序访问所有节点DLR
    public void preOrderTraverse(Node root) {
        if (root == null) {
            return;
        }
        System.out.println(root.data);
        preOrderTraverse(root.leftChild);
        preOrderTraverse(root.rightChild);

    }
    //后序访问所有节点LRD
    public void eploguiOrderTraverse(Node root) {
        if (root==null) {
            return;
        }
        eploguiOrderTraverse(root.leftChild);
        eploguiOrderTraverse(root.rightChild);
        System.out.println(root.data);

    }

}
