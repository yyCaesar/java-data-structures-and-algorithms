package com.ty.binaryTree;

import org.junit.Test;

public class TestTreeTraversal {

    @Test
    public void order(){

        /**
         *           1
         *          / \
         *        2    3
         *       /    / \
         *      4    5   6
         * */

        TreeNode<Integer>  root = new TreeNode<Integer> (1,
                new TreeNode<Integer> (2,new TreeNode<Integer> (4),null),
                new TreeNode<Integer> (3,new TreeNode<Integer> (5),new TreeNode<Integer> (6)));

        TreeTraversal treeTraversal = new TreeTraversal();
//        treeTraversal.preOrder(root);  // 1 2 4 3 5 6
//        treeTraversal.inOrder(root);   // 4 2 1 5 3 6
//        treeTraversal.postOrder(root); // 4 2 5 6 3 1

//        treeTraversal.preOrinOrder_nonRecursion(root);
        treeTraversal.portOrder_nonRecursion(root);

    }

}
