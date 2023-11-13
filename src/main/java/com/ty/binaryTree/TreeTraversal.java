package com.ty.binaryTree;

/**
 * 遍历树
 * */
public class TreeTraversal {


    /**
     * 前序遍历
     * */
    public void preOrder(TreeNode node){
        //根 -> 左 -> 右
        if (node == null){
            return;
        }
        System.out.println(node.value + "\t");
        preOrder(node.left);
        preOrder(node.right);
    }


}
