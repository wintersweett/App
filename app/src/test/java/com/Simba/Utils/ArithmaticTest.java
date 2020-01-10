package com.Simba.Utils;

import com.Simba.Utils.SearchBinaryTree.TreeNode;
import com.Simba.entity.Mahjong;

import org.junit.Test;

import java.util.LinkedList;

public class ArithmaticTest {
    @Test
    public void isRight() {
        LinkedList<Mahjong> list=new LinkedList<>();
        list.add(new Mahjong(3,1));
        list.add(new Mahjong(2,5));
        list.add(new Mahjong(3,9));
        System.out.println(list);
    }

    @Test
    public void digui() {
        Arithmatic.func(3);
    }
    @Test
    public void fact() {
        System.out.println(Arithmatic.factorial(5));
    }
    @Test
    public void tree() {
        BinaryTree tree=new BinaryTree("A");
        tree.createTree();
       // tree.preOrderTraverse(tree.root);
        tree.eploguiOrderTraverse(tree.root);
    }
    @Test
    public void binarySort() {
        int[] a={23,25,34,45,56};
        System.out.println(Arithmatic.binarySort(a,0,4,39));


    }
    @Test
    public void quickSort() {
        int[]a={9,8,6,10,5,3};
        Arithmatic.quickSort(a,0,5);
        for (int i:a) {
            System.out.print(i+" ");
        }

    }
    @Test
    public void merge() {
        int []array={2,1,4,3,};
        Arithmatic.mergeSort(array,0,array.length-1);
        for (int i:array) {
            System.out.print(i+" ");
        }
    }
    @Test
    public void test() {

        f(3);
    }
    public void f(int n) {
        if (n < 0) {
            return;
        } else {
            f(n-1);
        }
        System.out.println(n);
    }
    @Test
    public void put() {
        SearchBinaryTree search=new SearchBinaryTree();
        int[]array={5,2,7,3,4,1,6};
        for (int i:array) {
            search.put(i);
        }
        search.midOrderTravers(search.root);
        System.out.print("=======");
        System.out.print(search.searchNode(5).data);
        System.out.println();

        TreeNode delNode=search.searchNode(5);
        search.delNode(delNode);
        search.midOrderTravers(search.root);



    }
    @Test
    public void printMap() {
         int[][] map = {
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 1, 1, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1, 0, 1},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 1},
                {1, 1, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 0, 0},
                {1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 1, 1, 1},
                {0, 0, 0, 1, 1, 1, 0, 1, 1, 1, 0, 0, 0, 0},
                {0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 0, 0, 1},
                {0, 0, 0, 1, 0, 1, 0, 1, 0, 1, 1, 1, 0, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 1, 0, 1, 0, 1},
                {1, 1, 1, 0, 1, 1, 1, 1, 1, 1, 0, 0, 0, 1},
                {0, 0, 1, 1, 1, 0, 0, 0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0},
                {1, 0, 0, 0, 0, 1, 1, 0, 0, 0, 1, 1, 1, 0},
                {1, 0, 1, 1, 1, 1, 0, 0, 0, 1, 1, 0, 1, 1},
                {1, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 1, 1},
                {1, 0, 0, 0, 0, 1, 0, 0, 0, 0, 1, 0, 1, 1}
        };
        MapUtils.printMap(map);
    }
}