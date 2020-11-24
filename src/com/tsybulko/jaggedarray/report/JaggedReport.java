package com.tsybulko.jaggedarray.report;

import java.util.Arrays;

public class JaggedReport {
    public void reportBySum(int[][] array){
        System.out.println("Sorted by sum of strings: " + Arrays.deepToString(array));
    }
    public void reportByMax(int[][] array){
        System.out.println("Sorted by max elements of strings: " + Arrays.deepToString(array));

    }
    public void reportByMin(int[][] array){
        System.out.println("Sorted by min elements of strings: " + Arrays.deepToString(array));

    }
}
