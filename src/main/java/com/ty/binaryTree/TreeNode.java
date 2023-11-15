package com.ty.binaryTree;

import sun.reflect.generics.tree.Tree;

/**
 * 树节点
 * */
public class TreeNode<T> {

    //value
    //leftNode
    //rightNode

    public T value;
    public TreeNode<T> left;
    public TreeNode<T> right;

    public TreeNode(T value){
        this.value = value;
    }

    public TreeNode(T value,TreeNode<T> left,TreeNode<T> right){
        this.value = value;
        this.left = left;
        this.right = right;
    }



}
