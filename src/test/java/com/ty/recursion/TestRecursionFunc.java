package com.ty.recursion;

import org.junit.Test;

public class TestRecursionFunc {
    @Test
    public void insertion(){
        int[] arr = {2,4,5,10,7,1};
        recursionFunc recursion = new recursionFunc();
        recursion.insertion(arr,1);
    }
}
