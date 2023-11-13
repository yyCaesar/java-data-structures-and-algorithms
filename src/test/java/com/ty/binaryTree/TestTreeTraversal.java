package com.ty.binaryTree;

import org.junit.Test;

public class TestTreeTraversal {

    @Test
    public void preOrder(){

        TreeNode root = new TreeNode(1,
                new TreeNode(2,new TreeNode(4),null),
                new TreeNode(3,new TreeNode(5),new TreeNode(6)));

        TreeTraversal treeTraversal = new TreeTraversal();
        treeTraversal.preOrder(root);

    }

}
