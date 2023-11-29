package com.ty.redBlackTree;

public class RedBlackTree {

    private RedBlackTree root;

    private static class Node{

        int key;
        Object value;
        Node left;
        Node right;
        Node parent;
        Color color = Color.RED;
    }

    enum Color{
        RED,BLACK;
    }

}
