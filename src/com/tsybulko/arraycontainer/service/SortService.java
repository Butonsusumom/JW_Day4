package com.tsybulko.arraycontainer.service;

import com.tsybulko.arraycontainer.entity.Array;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class SortService {
    static final Logger rootLogger = (Logger) LogManager.getRootLogger();

    public static Array selectionSort(Array array) {
        rootLogger.info("Selection sort of the array");
        int[] newArray = array.getElements();
        for (int i = 0; i < array.getSize(); i++) {
            int min = newArray[i];
            int minId = i;
            for (int j = i+1; j < array.getSize(); j++) {
                if (newArray[j] < min) {
                    min = newArray[j];
                    minId = j;
                }
            }
            int temp = newArray[i];
            newArray[i] = min;
            newArray[minId] = temp;
        }
        return new Array(newArray);
    }

    public static Array bubbleSort(Array array) {
        rootLogger.info("Bubble sort of the array");
        int[] newArray = array.getElements();
        boolean sorted = false;
        while(!sorted) {
            sorted = true;
            for (int i = 0; i < array.getSize() - 1; i++) {
                if (newArray[i] > newArray[i+1]) {
                    swap(newArray, i, i+1);
                    sorted = false;
                }
            }
        }
        return new Array(newArray);
    }

    public static Array insertionSort(Array array) {
        rootLogger.info("Insertion sort of the array");
        int[] newArray = array.getElements();
        for (int i = 1; i < array.getSize(); i++) {
            int current = newArray[i];
            int j = i - 1;
            while(j >= 0 && current < newArray[j]) {
                newArray[j+1] = newArray[j];
                j--;
            }
            newArray[j+1] = current;
        }
        return new Array(newArray);
    }

    public static final void swap( int[] arr, int i,  int j) {
        int tmp = arr[i];
        arr[i] = arr[j];
        arr[j] = tmp;
    }

}
