package com.ty.binaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 树节点
 * */
public class TreeNode {

    //value
    //leftNode
    //rightNode

    public int value;
    public TreeNode left;
    public TreeNode right;

    public TreeNode(int value){
        this.value = value;
    }

    public TreeNode(int value,TreeNode left,TreeNode right){
        this.value = value;
        this.left = left;
        this.right = right;
    }



}
