package com.ty.binaryTree;

import org.junit.Test;

public class TestLeetCode {

    @Test
    public void sequencePrint(){
        /**
         *      1
         *    2  2
         *   3
         *  4
         * */
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, new TreeNode<>(3, new TreeNode<>(4), null), null),
                new TreeNode<>(2, null, null));

        LeetCode leetcode =  new LeetCode();
        leetcode.sequencePrint(root);

    }

    @Test
    public void postfixExpressions(){
        String[] strArr = {"2","1","-","3","*"};
        LeetCode leetcode =  new LeetCode();
        TreeNode<String> node = leetcode.postfixExpressions(strArr);
    }


    @Test
    public void overTurn(){
        /**
         *      1
         *    2  2
         *   3
         *  4
         * */
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, new TreeNode<>(3, new TreeNode<>(4), null), null),
                new TreeNode<>(2, null, null));

        TreeNode<Integer> node = new LeetCode().overTurn(root);
    }


    @Test
    public void maxDepth_nonRecursion(){
        /**
         *      1
         *    2  2
         *   3
         *  4
         * */
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, new TreeNode<>(3, new TreeNode<>(4), null), null),
                new TreeNode<>(2, null, null));

        int result = new LeetCode().maxDepth_Queue_nonRecursion(root);
        System.out.println(result);
    }

    @Test
    public void maxDepth(){
        TreeNode<Integer> root = new TreeNode<>(1,
                new TreeNode<>(2, new TreeNode<>(3, new TreeNode<>(4), null), null),
                new TreeNode<>(2, null, null));

//        int level = new LeetCode().maxDepth(root);
        int level = new LeetCode().maxDepth_Stack_nonRecursion(root);
        System.out.println(level);
    }

    @Test
    public void isSymmetric(){
        /**
         *    1
         *   2 2
         * 3 n 2 3
         * */

        TreeNode<Integer> root = new TreeNode<Integer>(1,
                new TreeNode<Integer>(2,new TreeNode<Integer>(3),null),
                new TreeNode<Integer>(2,null,new TreeNode<Integer>(3)));

          boolean result = new LeetCode().isSymmetric(root);
        System.out.println(result);

    }


}
