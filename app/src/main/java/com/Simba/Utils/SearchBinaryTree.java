package com.Simba.Utils;

public class SearchBinaryTree {
    //根节点
    TreeNode root;
    /*
    添加节点
     */
    public TreeNode put(int data) {
        if (root==null) {
            TreeNode node=new TreeNode(data);
            root=node;
            return root;
        }
        TreeNode parent=null;
        TreeNode node=root;
        //找到要放入的位置
        while (node != null) {
            parent=node;
            if (data<node.data) {
                node=node.leftChild;
            } else if (data > node.data) {
                node = node.rightChild;
            } else {
                //是重复值就不理会了
                return node;
            }
        }

        //生成一个节点放入
        TreeNode newNode=new TreeNode(data);
        if (data < parent.data) {
            parent.leftChild = newNode;
        } else {
            parent.rightChild=newNode;
        }
        newNode.parent=parent;
        return newNode;
    }

    /*
    中序遍历
     */
    public void midOrderTravers(TreeNode root) {
        if (root==null) {
            return;
        }

        //LDR
        midOrderTravers(root.leftChild);
        System.out.print(root.data+" ");
        midOrderTravers(root.rightChild);
    }

    /*
    查找一个节点
     */
    public TreeNode searchNode(int data) {
        if (root==null) {
            return null;

        }
        TreeNode node=root;
        while (node != null) {
            if (node.data==data) {
                return node;
            } else if (data<node.data) {
                node=node.leftChild;
            } else if (data>node.data) {
                node=node.rightChild;
            }
        }
        return node;

    }

    /*
    删除节点
    要删除的节点在树上是一定要存在的才删除
     */
    public void delNode(TreeNode node) {
        TreeNode parent=node.parent;//先得到父亲，方便后面的操作
        //1、叶子节点(有父节点和无父节点）
        if (node.rightChild==null&& node.leftChild==null) {
            if (parent==null) {
                root=null;
            } else if (parent.rightChild==node) {
                parent.rightChild=null;
            } else if (parent.leftChild==node) {
                parent.leftChild=null;
            }
            node.parent=null;
        } else if (node.leftChild !=null && node.rightChild==null) {
            //2、只有左孩子
            if (parent == null) {//如果要删除的是根
                node.parent = null;
                node.leftChild.parent = null;
                root = node.leftChild;
            } else {
                if (parent.leftChild==node) {//如果要删除的节点是父亲的左边
                    node.leftChild.parent=parent;
                    parent.leftChild=node.leftChild;

                } else if (parent.rightChild==node) {//如果要删除的节点是父亲的右边
                    node.leftChild.parent=parent;
                    parent.rightChild=node.leftChild;
                }
                node.parent=null;
            }
        } else if (node.rightChild != null && node.leftChild == null) {
            //3、只有右孩子
            if (parent == null) {
                node.parent = null;
                node.rightChild.parent = null;
                root = node.rightChild;
            } else {
                if (parent.leftChild==node) {//如果要删除的节点是父亲的左孩子
                    node.rightChild.parent=parent;
                    parent.leftChild=node.rightChild;
                } else if (parent.rightChild==node) {//如果要删除的节点是父亲的右孩子
                    node.rightChild.parent=parent;
                    parent.rightChild=node.rightChild;
                }
                node.parent=null;
            }

        } else {
            //4、有左右孩子
            if (node.rightChild.leftChild==null) {//被删节点的右子树的左子树为null,就直接补上右子树
                node.rightChild.leftChild=node.leftChild;
                if (parent == null) {
                    root = node.rightChild;
                } else {
                    if (parent.leftChild==node) {
                        parent.leftChild=node.rightChild;
                    } else if (parent.rightChild==node) {
                        parent.rightChild=node.rightChild;
                    }
                }
                node.parent=null;
            } else {//被删节点的右子树的左子树不为null，要补上右子树的左子树上最小的一个
                TreeNode minTreeLeftNode=getMinTreeLeftNode(node.rightChild);
                //1将最小的节点，放置被删节点处
                minTreeLeftNode.leftChild=node.leftChild;
                //2如果最小节点还有右孩子
                minTreeLeftNode.parent.leftChild=minTreeLeftNode.rightChild;

                //3将最小节点右孩子=被删节点右孩子
                minTreeLeftNode.rightChild=node.rightChild;
                //4
                if (parent == null) {
                    root = minTreeLeftNode;
                } else {
                    if (parent.leftChild == node) {
                        parent.leftChild=minTreeLeftNode;
                        minTreeLeftNode.parent=parent;

                    } else if (parent.rightChild==node) {
                        parent.rightChild=minTreeLeftNode;
                        minTreeLeftNode.parent=parent;

                    }
                }





            }

        }


    }

    private TreeNode getMinTreeLeftNode(TreeNode node) {
        TreeNode curRoot;
        if (node == null) {
            return null;
        } else {
            curRoot=node;
            while (curRoot.leftChild != null) {
                curRoot=curRoot.leftChild;
            }
        }

return curRoot;
    }


    public static class TreeNode {
        int data;
        TreeNode leftChild;
        TreeNode rightChild;
        TreeNode parent;
        public TreeNode(int data) {
            this.data=data;
            this.leftChild=null;
            this.rightChild=null;
            this.parent=null;
        }
    }
}
