package com.ty.redBlackTree;

public class RedBlackTree {

    private Node root;


    /**
     * 判断节点是否是红色
     */
    boolean isRed(Node node) {
        return node != null && node.color == Color.RED;
    }

    /**
     * 判断节点是否是黑色
     */
    boolean isBlack(Node node) {
//            return !isRed(node);
        return node == null || node.color == Color.BLACK;
    }


    /**
     * 左旋
     */
    private void leftRotate(Node node) {
        Node currentParent = node.parent;
        Node theFutureParent = node.right;
        Node theFutureGrandson = theFutureParent.left;

        if (theFutureGrandson != null){
            theFutureGrandson.parent = node;
        }

        theFutureParent.left = node;
        theFutureParent.parent = currentParent;

        node.right = theFutureGrandson;
        node.parent = theFutureParent;
        
        if (currentParent == null){
            root = theFutureParent;
        } else if (currentParent.left == node) {
            currentParent.left = theFutureParent;
        } else {
            currentParent.right = theFutureParent;
        }
    }


    /**
     * 右旋
     * 1.parent节点处理
     * 2.旋转后新根的父子关系
     */
    private void rightRotate(Node node) {

        //当前节点的左节点 => 未来的根节点
        //当前节点 => 未来根节点的右节点
        //当前节点的左节点的右节点 => 未来根节点的右节点的左节点

        Node currentParent = node.parent;
        Node theFutureParent = node.left;
        Node theFutureGrandSon = theFutureParent.right;

        if (theFutureGrandSon != null) {
            theFutureGrandSon.parent = node;
        }

        theFutureParent.right = node;
        theFutureParent.parent = currentParent;

        node.left = theFutureGrandSon;
        node.parent = theFutureParent;

        if (currentParent == null) {
            root = theFutureParent;
        } else if (currentParent.left == node) {
            currentParent.left = theFutureParent;
        } else {
            currentParent.right = theFutureParent;
        }
    }


    private static class Node {

        int key;
        Object value;
        Node left;
        Node right;
        Node parent;
        Color color = Color.RED;


        public Node(int key) {
            this.key = key;
        }

        public Node(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public Node(int key, Object value, Node left, Node right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;

            if (left != null) {
                left.parent = this;
            }

            if (right != null) {
                right.parent = this;
            }
        }


        //红黑树特性
        //1.根节点是黑色
        //2.红色节点不能相邻
        //3.所有null节点都视为黑色
        //4.从根节点到任意一个叶子节点，路径中的黑色节点树要一样


        //                8
        //             3     9
        //         1(自身)


        /**
         * 是否是左孩子
         */
        boolean isLeftChild() {
            return parent != null && parent.left == this;
        }

        /**
         * 获取叔叔节点
         */
        Node getUncle() {
            if (parent == null || parent.parent == null) {
                return null;
            }

            if (parent.isLeftChild()) {
                return parent.parent.right;
            } else {
                return parent.parent.left;
            }
        }

        /**
         * 获取兄弟节点
         */
        Node getBrother() {
            if (parent == null) {
                return null;
            }
            if (parent.isLeftChild()) {
                return parent.right;
            } else {
                return parent.left;
            }
        }
    }


    enum Color {
        RED, BLACK;
    }

}
