package com.Simba.Utils;

import com.Simba.Utils.SearchBinaryTree.TreeNode;
import com.Simba.entity.Mahjong;

import org.junit.Test;

import java.util.ArrayList;
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
    @Test

    public void haffman() {
        ArrayList<HaffmanTree.TreeNode> list=new ArrayList<>();
        HaffmanTree.TreeNode<String> node=new HaffmanTree.TreeNode<>("good",50);
        list.add(node);
        list.add(new HaffmanTree.TreeNode("morning",10));
        list.add(new HaffmanTree.TreeNode("afternoon",20));
        list.add(new HaffmanTree.TreeNode("dinner",110));
        list.add(new HaffmanTree.TreeNode("night",200));
        HaffmanTree haffmanTree=new HaffmanTree();
        haffmanTree.createHaffmanTree(list);
        haffmanTree.showHaffman(haffmanTree.root);

        haffmanTree.getCode(node);
    }

    @Test
    public void avlTree() {
        Integer[] nums={5,8,2,0,1,-2};
        AVLBTree<Integer> avlbTree=new AVLBTree<>();
        for (int i = 0; i < nums.length; i++) {
            avlbTree.insertElement(nums[i]);
        }
        avlbTree.showAVL(avlbTree.root);
    }
    @Test
    public void testGraph() {
        Graph graph=new Graph(5);
        graph.creatSimpleMatrix();
        graph.dfs();
    }

    @Test
    public void feibonaqishu() {
        LCSandKMP lcs=new LCSandKMP();
        System.out.println(lcs.f(2));

    }
    @Test
    public void testKMP() {
        String str="ababcabcbababcabacaba";
        String dest="ababcaba";
        int[]array=LCSandKMP.kmpNext(dest);
        System.out.println(LCSandKMP.kmp(str,dest,array));
    }
    @Test
    public void testSquareUp() {
        SquareUp squareUp=new SquareUp();
        squareUp.test();
    }
    @Test
    public void testEightQueens() {
        eightQueens.eightQueens(0);
    }
@Test
    public void testAov() {
//        AOVandTopologicalSorting aov=new AOVandTopologicalSorting();
//        aov.creatSheet();
//    int a=1;
//    System.out.println(++a);
//    System.out.println(a);
//
//    int b=2;
//    System.out.println(b++);
//    System.out.println(b);

    AOEsort aoEsort=new AOEsort();
    aoEsort.creatAOE();
}
}