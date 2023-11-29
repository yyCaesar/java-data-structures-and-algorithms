package com.ty.avlTree;

public class AVLTree {

    AVLNode root;

    /**
     * 失衡四种情况
     * 1.左左
     * balanceFactor > 1
     * 失衡节点左孩子 balanceFactor >= 0
     * 2.左右
     * balanceFactor > 1
     * 失衡节点左孩子 balanceFactor < 0
     * 3.右右
     * balanceFactor < -1
     * 失衡节点右孩子 balanceFactor > 0
     * 4.右左
     * balanceFactor < -1
     * 失衡节点右孩子 balanceFactor <= 0
     */
    //判断及调整树平衡
    public AVLNode banlance(AVLNode node) {

        if (node == null) {
            return null;
        }

        int balanceFactor = balanceFactor(node);

        if (balanceFactor > 1 && balanceFactor(node.left) >= 0) { //LL
            return rightRotate(node);
        } else if (balanceFactor > 1 && balanceFactor(node.left) < 0) { //LR
            return leftRightRotate(node);
        } else if (balanceFactor < -1 && balanceFactor(node.right) > 0) { //RL
            return rightLeftRotate(node);
        } else if (balanceFactor < -1 && balanceFactor(node.right) <= 0) { //RR
            return leftRightRotate(node);
        }

        return node;
    }


    //删除
    public void remove(int key) {

        //1.node == null
        //2.没找到，继续找
        //3.找到了
        // 1) 没有孩子
        // 2) 只有左孩子
        // 3) 只有右孩子
        // 4) 有两个孩子

        root = doRemove(root, key);
    }

    public AVLNode doRemove(AVLNode node, int key) {

        if (node == null) {
            return null;
        }

        if (key < node.key) {
            node.left = doRemove(node.left, key);
        } else if (key > node.key) {
            node.right = doRemove(node.right, key);
        } else {
            //找到了

            if (node.left == null) {
                node = node.right;
            } else if (node.right == null) {
                node = node.left;
            } else {

                //找后继节点
                AVLNode successorNode = node.right;
                while (successorNode.left != null) {
                    successorNode = successorNode.left;
                }

                successorNode.right = doRemove(node.right, successorNode.key);
                successorNode.left = node.left;
                node = successorNode;
            }
        }

        if (node == null){
            return null;
        }

        updateHeight(node);
        return banlance(node);
    }


    //新增
    public void put(int key, Object value) {

        //1.找到空位，创建新节点
        //2.key存在，更新value
        //3.没找到继续找
        root = doPut(root, key, value);
    }

    public AVLNode doPut(AVLNode node, int key, Object value) {

        if (node == null) {
            return new AVLNode(key, value);
        }

        if (key == node.key) {
            node.value = value;
            return node;
        }

        if (key < node.key) {
            node.left = doPut(node.left, key, value);
        } else {
            node.right = doPut(node.right, key, value);
        }

        updateHeight(node);
        return banlance(node);
    }


    //右左旋
    //先右旋右子树
    //再左旋根节点
    public AVLNode rightLeftRotate(AVLNode node) {
        node.right = rightRotate(node.right);
        return leftRotate(node);
    }


    //左右旋
    //先左旋左子树
    //在右旋根节点
    public AVLNode leftRightRotate(AVLNode node) {
        node.left = leftRotate(node.left);
        return leftRotate(node);
    }


    //左旋
    //根节点右孩子 => 根节点
    //根节点 => 根节点左孩子
    //根节点左孩子的右孩子 => 根节点右孩子的左孩子
    public AVLNode leftRotate(AVLNode node) {
        AVLNode root = node.right;
        AVLNode grandson = root.left;
        root.left = node;
        node.right = grandson;
        return root;
    }


    //右旋
    //节点左孩子 => 根节点
    //根节点 => 根节点的右孩子
    //节点左孩子的右孩子 => 根节点的右孩子的左孩子
    public AVLNode rightRotate(AVLNode node) {
        AVLNode root = node.left;
        AVLNode grandson = root.right;
        root.right = node;
        node.left = grandson;
        return root;
    }


    //平衡因子
    //左节点高度 - 右节点高度
    //平衡因子等于  0、1、-1 表示平衡
    //平衡因子大于  1 表示左边树高
    //平衡因子小于 -1 表示右边树高
    public int balanceFactor(AVLNode node) {
        return getHeight(node.left) - getHeight(node.right);
    }

    //更新节点高度
    public void updateHeight(AVLNode node) {
        //节点左右比较，取最大值
        node.height = Integer.max(getHeight(node.left), getHeight(node.right)) + 1;
    }

    //获取节点高度
    public int getHeight(AVLNode node) {
        return node == null ? 0 : node.height;
    }


    static class AVLNode {

        int key;
        Object value;
        AVLNode left;
        AVLNode right;

        int height = 1; //高度默认1

        public AVLNode(int key) {
            this.key = key;
        }

        public AVLNode(int key, Object value) {
            this.key = key;
            this.value = value;
        }

        public AVLNode(int key, int value, AVLNode left, AVLNode right) {
            this.key = key;
            this.value = value;
            this.left = left;
            this.right = right;
        }
    }


}
