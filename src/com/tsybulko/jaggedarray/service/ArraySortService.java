package com.tsybulko.jaggedarray.service;

import com.tsybulko.jaggedarray.service.comporation.CompareByMax;
import com.tsybulko.jaggedarray.service.comporation.CompareByMin;
import com.tsybulko.jaggedarray.service.comporation.CompareBySum;
import org.apache.logging.log4j.LogManager;

import java.util.Comparator;
import java.util.logging.Logger;

public class ArraySortService {
    static final Logger rootLogger = (Logger) LogManager.getRootLogger();

    public int[][] sortByMax(int[][] array){
        rootLogger.info("Sort two demencions array by max elements of strings");
        CompareByMax compMax = new CompareByMax();
        int[][] resArray = bubbleSort(array, compMax);
        return resArray;
    }

    public int[][] sortByMin(int[][] array){
        rootLogger.info("Sort two demencions array by min elements of strings");
        CompareByMin compMin = new CompareByMin();
        int[][] resArray = bubbleSort(array, compMin);
        return resArray;
    }

    public int[][] sortBySum(int[][] array){
        rootLogger.info("Sort two demencions array by sum of strings");
        CompareBySum compSum = new CompareBySum();
        int[][] resArray = bubbleSort(array, compSum);
        return resArray;
    }



    public static int[][] bubbleSort(int[][] array, Comparator<int[]> comparator) {
        boolean sorted = false;
        int temp;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.length - 1; i++) {
                if (comparator.compare(array[i], array[i+1])>0) {
                    swap(array, i, i+1);
                    sorted = false;
                }
            }
        }
        return array;
    }

    public static final void swap( int[][] arr, int i,  int j) {
        int[] tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
