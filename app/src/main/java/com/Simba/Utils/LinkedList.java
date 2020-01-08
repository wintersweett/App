package com.Simba.Utils;

/*
手写双向链表
 */
public class LinkedList<E> {
    private static class Node<E> {
        E item;//节点的数据域
        Node<E> pre;
        Node<E> next;
        public  Node(Node<E> pre,E item,Node<E>next){
            this.pre=pre;
            this.item=item;
            this.next=next;
        }

    }
    public LinkedList() {

    }
    Node<E> first;//头节点
    Node<E>last;//尾节点
    int size;
    public void add(E e) {
        linkLast(e);
    }
    //添加数据在index位置
    public void add(int index,E e) {
        if (index < 0 || index > size) {
            return ;
        }
        if (index == size) {//如果添加的位置是尾部
            linkLast(e);
        } else {
            Node<E>target=node(index);
            Node<E>pre=target.pre;
            Node<E>newNode=new Node<>(pre,e,target);

            if (pre == null) {
                first=newNode;
                target.pre=newNode;

            } else {

                pre.next=newNode;
                target.pre=newNode;
            }
            size++;
        }
    }
    //删除元素
    public void remove(int index) {
        Node<E>target=node(index);
        unLinkNode(target);
    }

    private void unLinkNode(Node<E> target) {
        Node<E> pre=target.pre;
        Node<E>next=target.next;
        if (pre == null) {
            first=target.next;
        } else {
            pre.next=target.next;
        }
        if (next == null) {
            last = target.pre;

        } else {
            next.pre=target.pre;
        }
        size--;
    }

    //直接在尾部添加的情况
    private void linkLast(E e) {
        Node<E> newNode=new Node<>(last,e,null);
        Node<E> l=last;//l作为临时变量保存的中间值
        last=newNode;//新节点变为last
        if (l == null) {
            first=newNode;
        } else {

            l.next=newNode;//以前last的next指向新节点
        }
        size++;
    }
    //中间插入情况下，需要先搜索定位到，才能插入
    //查找位置
    public E get(int index) {
        if (index <0||index>size) {
            return null;
        }
        return node(index).item;//返回那个节点的数据域

    }
//获取index位置上的节点
    private Node<E> node(int index) {
        if (index < (size>>1)) {

            Node<E> node = first;
            for (int i = 0; i < index; i++) {
                node = node.next;
            }
            return node;
        } else {
            Node<E> node=last;
            for (int i=size-1;i>index;i--) {
                node=node.pre;
            }

            return node;
        }


    }

}
