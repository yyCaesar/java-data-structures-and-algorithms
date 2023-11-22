package com.ty.recursion;

public class recursionFunc {



    /**
     * 插入排序
     * */
    public void insertion(int[] arr, int l) {

        if (l == arr.length){
            return;
        }

        int i = l - 1; //已排序的索引
        int temp = arr[l]; //未排序的数据

        while (i>=0 && arr[i] > temp){
            arr[i+1] = arr[i];
            i--;
        }

        if (i+1 != l){
            arr[i+1] = temp;
        }

        insertion(arr,l+1);
    }
}
