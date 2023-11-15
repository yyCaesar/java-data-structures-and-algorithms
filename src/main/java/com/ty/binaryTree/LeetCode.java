package com.ty.binaryTree;

import java.util.LinkedList;
import java.util.Objects;
import java.util.Queue;

public class LeetCode {


    /**
     * 最大深度（栈非递归）
     * */
    public int maxDepth_Stack_nonRecursion(TreeNode<Integer> node){
        return 0;
    }


    /**
     * 最大深度（队列非递归）
     * */
    public int maxDepth_Queue_nonRecursion(TreeNode<Integer> node){
        //层序遍历
        Queue<TreeNode<Integer>> queue = new LinkedList<>();
        queue.offer(node);
        int level = 0;
        while (!queue.isEmpty()){

            int size = queue.size();
            for (int i = 0;i < size;i++){

                TreeNode<Integer> poll = queue.poll();

                if (poll.left != null){
                    queue.offer(poll.left);
                }

                if (poll.right != null){
                    queue.offer(poll.right);
                }
            }
            level ++;
        }
        return level;
    }



    /**
     * 最大深度（递归）
     * */
    public int maxDepth(TreeNode<Integer> node){

        if (node == null){
            return 0;
        }

       int l_level = maxDepth(node.left);
       int r_level = maxDepth(node.right);

       return Integer.max(l_level,r_level) + 1;
    }


    /**
     * 是否对称二叉树
     * */
    public boolean isSymmetric(TreeNode<Integer> node){
       return this.isSymmetric_Check(node.left,node.right);
    }

    private boolean isSymmetric_Check(TreeNode<Integer> left,TreeNode<Integer> right){

        if (left == null && right == null){
            return true;
        }

        if (left == null || right == null){
            return false;
        }

        if (left.value != right.value){
            return false;
        }

        return isSymmetric_Check(left.left,right.right) && isSymmetric_Check(left.right,right.left);
    }



}
