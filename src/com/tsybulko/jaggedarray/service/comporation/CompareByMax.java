package com.tsybulko.jaggedarray.service.comporation;

import com.tsybulko.jaggedarray.exception.JaggedArrayException;
import com.tsybulko.jaggedarray.util.ArrayUtilities;
import java.util.Comparator;

public class CompareByMax implements Comparator<int[]> {

    @Override
    public int compare(int[] arr1, int[] arr2) {
        ArrayUtilities arrayUtil = new ArrayUtilities();
            if (arrayUtil.getMax(arr1)>arrayUtil.getMax(arr2)) {
                return 1;
            }
            return 0;
    }
}
