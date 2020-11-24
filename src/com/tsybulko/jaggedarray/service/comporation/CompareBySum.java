package com.tsybulko.jaggedarray.service.comporation;

import com.tsybulko.jaggedarray.util.ArrayUtilities;

import java.util.Comparator;

public class CompareBySum implements Comparator<int[]>{
    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayUtilities arrayUtil = new ArrayUtilities();
        if (arrayUtil.getSum(arr1)>arrayUtil.getSum(arr2)) {
            return 1;
        }
        return 0;
    }
}
