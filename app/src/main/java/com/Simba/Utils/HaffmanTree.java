package com.Simba.Utils;

import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedList;
import java.util.Stack;

public class HaffmanTree {
    TreeNode root;

    //创建haffman树  10  20 50 110  200

    public TreeNode createHaffmanTree(ArrayList<TreeNode> list) {
        while (list.size() > 1) {
            Collections.sort(list);//对list排序
            TreeNode left=list.get(list.size()-1);
            TreeNode right=list.get(list.size()-2);
            TreeNode parent=new TreeNode("p",left.weight+right.weight);
            parent.leftChild=left;
            left.parent=parent;
            parent.rightChild=right;
            right.parent=parent;
            list.remove(left);
            list.remove(right);
            list.add(parent);
        }
        root=list.get(0);



        return root;
    }
    /*
    编码

     */
    public void getCode(TreeNode node) {
        TreeNode tNode=node;
        Stack<String> stack=new Stack<>();
        while (tNode != null && tNode.parent != null) {
            //left 0 ;right 1
            if (tNode.parent.leftChild==tNode) {
                stack.push("0");
            } else if (tNode.parent.rightChild==tNode) {
                stack.push("1");
            }
            tNode=tNode.parent;//往上搜
        }
        System.out.println();
        while (!stack.isEmpty()) {
            System.out.print(stack.pop());
        }
    }

    public void showHaffman(TreeNode root) {
        LinkedList<TreeNode> list=new LinkedList<>();
        list.offer(root);//入队
        while (!list.isEmpty()) {
            TreeNode node =list.pop();
            System.out.println(node.data);
            if (node.leftChild!=null) {
                list.offer(node.leftChild);
            }
            if (node.rightChild!=null) {
                list.offer(node.rightChild);
            }
        }
    }










    public static class TreeNode<T> implements Comparable<TreeNode<T>> {
        T data;
        int weight;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;
        public TreeNode(T data,int weight) {
            this.data=data;
            this.weight=weight;
            leftChild=null;
            rightChild=null;
            parent=null;
        }

        @Override
        public int compareTo(TreeNode<T> o) {
            if (this.weight>o.weight) {
                return -1;
            } else if (this.weight<o.weight) {
                return 1;
            }
            return 0;
        }
    }
}
