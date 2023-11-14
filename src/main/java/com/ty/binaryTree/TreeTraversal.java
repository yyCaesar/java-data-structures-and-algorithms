package com.ty.binaryTree;

import java.util.Stack;

/**
 * 遍历树
 * */
public class TreeTraversal {

    /**
     * 后序遍历（非递归遍历）
     * */
    public void portOrder_nonRecursion(TreeNode node){
        TreeNode pop = null;
        TreeNode current = node;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()){

            if (current != null){
                stack.push(current);
                current = current.left;
            } else {
                TreeNode peek = stack.peek();
                if (peek.right == null || peek.right == pop){
                    pop = stack.pop();
                    System.out.println(pop);
                }else {
                    current = peek.right;
                }
            }

        }


    }


    /**
     * 前、中序遍历（非递归遍历）
     * */
    public void preOrinOrder_nonRecursion(TreeNode node){
        //栈 -> 压入、弹出数据
        TreeNode current = node;
        Stack<TreeNode> stack = new Stack<>();

        while (current != null || !stack.isEmpty()){
            if (current != null){
                stack.push(current);
//                System.out.println("前序遍历："+ current.value);
                current = current.left;
            } else {
                //左边路走完了，往回走、右
                TreeNode pop = stack.pop();
                System.out.println("中序遍历："+ pop.value);
                current = pop.right;
            }

        }



    }


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

    /**
     * 中序遍历
     * */
    public void inOrder(TreeNode node){
        //左 -> 根 -> 右
        if(node == null){
            return;
        }

        inOrder(node.left);
        System.out.println(node.value + "\t");
        inOrder(node.right);
    }

    /**
     * 后序遍历
     * */
    public void postOrder(TreeNode node){
        //左 -> 右 -> 根
        if (node == null){
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.value + "\t");
    }


}
