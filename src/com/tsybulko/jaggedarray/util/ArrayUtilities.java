package com.tsybulko.jaggedarray.util;


import com.tsybulko.jaggedarray.exception.JaggedArrayException;
import org.apache.logging.log4j.LogManager;

import java.util.logging.Logger;

public class ArrayUtilities {

    static final Logger rootLogger = (Logger) LogManager.getRootLogger();

    public int getMax (int[] array)  {

        int max = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] > max){
                max = array[i];
            }
        }
        //rootLogger.info("Get max array element");
        return max;
    }

    public int getMin (int[] array)  {
        int min = array[0];
        for (int i = 1; i < array.length; i++){
            if (array[i] < min){
                min = array[i];
            }
        }
        rootLogger.info("Get max array element");
        return min;
    }

    public int getSum (int[] array){
        int sum=0;
        for (int num:
             array) {
            sum+=num;
        }
        return sum;
    }
}
