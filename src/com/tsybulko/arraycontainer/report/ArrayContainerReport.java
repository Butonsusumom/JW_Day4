package com.tsybulko.arraycontainer.report;


import com.tsybulko.arraycontainer.entity.Array;

public class ArrayContainerReport {
    public void arrayFromFile(Array array){
        System.out.println("Array read from file:  " + array);
    }

    public void randomArray(Array array){
        System.out.println("Random array:  " + array);
    }

}