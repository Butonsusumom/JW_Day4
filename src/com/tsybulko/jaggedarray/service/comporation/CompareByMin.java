package com.tsybulko.jaggedarray.service.comporation;

import com.tsybulko.jaggedarray.util.ArrayUtilities;

import java.util.Comparator;

public class CompareByMin implements Comparator<int[]> {
    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayUtilities arrayUtil = new ArrayUtilities();
        if (arrayUtil.getMin(arr1)>arrayUtil.getMin(arr2)) {
            return 1;
        }
        return 0;
    }
}
