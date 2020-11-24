package com.tsybulko.arraycontainer.entity;


import com.tsybulko.arraycontainer.exception.ArrayContainerException;
import com.tsybulko.arraycontainer.service.SortService;
import org.apache.logging.log4j.LogManager;

import java.util.Arrays;
import java.util.logging.Logger;

public class Array {
    static final Logger rootLogger = (Logger) LogManager.getRootLogger();
    private int[] elements;

    public Array(){
        elements = new int[0];
        rootLogger.info("Create empty array");
    }

    public Array(int size){
        elements = new int[size];
        rootLogger.info("Create array with fixed size");
    }

    public Array(int[] array){
        this.elements = array.clone();
        rootLogger.info("Create filled array");
    }

    public int get(int index) throws ArrayContainerException {
        if (index < 0 || index >= elements.length) {
            rootLogger.warning("Index out of range");
            throw new ArrayContainerException("Index out of range");
        }
        rootLogger.info("Get element by index");
        return elements[index];
    }

    public int[] getElements(){
        rootLogger.info("Get all elements");
        return elements.clone();
    }

    public boolean isSorted() {
        int[] intArray = elements;
        boolean sorted = true;
        for (int i=0 ;i<intArray.length - 1;i++){
            if (intArray[i] > intArray[i + 1]){
                sorted = false;
                break;
            }
        }
        rootLogger.info("Check if array is sorted");
        return sorted;
    }

    public int binarySearch( int key) throws ArrayContainerException {

        if(!isSorted()) {
            //SortService sortService = new SortService();
           // elements = SortService.selectionSort(this).getElements();
            rootLogger.warning("Array ia not sorted");
            throw new ArrayContainerException("Array is not sorted");
        }

        int low = 0;
        int high = getSize() - 1;
        int mid = (low + high)/2;

        while (low <= high) {
            if (elements[mid]< key) {
                low = mid + 1;
            } else if (elements[mid]> key) {
                high = mid - 1;
            } else if (elements[mid]== key) {
                break;
            }
            mid = (low + high)/2;
        }

        if (elements[mid] != key){
            rootLogger.warning("No such element in Array");
            throw new ArrayContainerException("No such element in Array");
        }
        else {
            rootLogger.info("Find id by kay value");
            return mid;
        }
    }

    public int getMax() throws ArrayContainerException {
        if (getSize() == 0){
            rootLogger.warning("Array is empty");
            throw new ArrayContainerException("Array is empty");
        }
        int[] intArray = getElements();
        int max = intArray[0];
        for (int i = 1; i < intArray.length; i++){
            if (intArray[i] > max){
                max = intArray[i];
            }
        }
        rootLogger.info("Get max element");
        return max;
    }

    public int getMin() throws ArrayContainerException {
        if (getSize() == 0){
            rootLogger.warning("Array is empty");
            throw new ArrayContainerException("Array is empty");
        }
        int[] intArray = getElements();
        int min = intArray[0];
        for (int i = 1; i < intArray.length; i++){
            if (intArray[i] < min){
                min = intArray[i];
            }
        }
        rootLogger.info("Get max element");
        return min;
    }

    public void set(int index, int value) throws ArrayContainerException {
        if (index < 0 || index >= elements.length){
            rootLogger.warning("Index out of range");
            throw new ArrayContainerException("Index out of range");
        }
        rootLogger.info("Set new value to element");
        elements[index] = value;
    }

    public void add(int value){
        elements = Arrays.copyOf(elements, elements.length + 1);
        int lastIndex = elements.length - 1;
        elements[lastIndex] = value;
        rootLogger.info("Add new element to array");
    }

    public int getSize(){
        rootLogger.info("Get array size");
        return elements.length;
    }

    @Override
    public String toString() {
        final StringBuilder sb = new StringBuilder("Array{");
        sb.append("array=").append(Arrays.toString(elements));
        sb.append('}');
        return sb.toString();
    }


    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Array)) return false;
        Array array = (Array) o;
        return Arrays.equals(elements, array.elements);
    }

    @Override
    public int hashCode() {
        return Arrays.hashCode(elements);
    }
}
