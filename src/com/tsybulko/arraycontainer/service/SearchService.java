package com.tsybulko.arraycontainer.service;
import com.tsybulko.arraycontainer.entity.Array;
import com.tsybulko.arraycontainer.util.CheckNumbers;
import org.apache.logging.log4j.LogManager;

import java.lang.reflect.Method;
import java.util.function.IntPredicate;
import java.util.logging.Logger;

public class SearchService {
    static final Logger rootLogger = (Logger) LogManager.getRootLogger();

    public Array findNumbers(Array array, IntPredicate condition){
        Array resultArray = new Array();
        for(int element : array.getElements()){
            if (condition.test(element)){
                resultArray.add(element);
            }
        }
        return resultArray;
    }

    public Array findSimple(Array array) {
        rootLogger.info("Find all simple numbers in array");
        return findNumbers(array, CheckNumbers::isSimple);
    }

    public Array findFibonacci(Array array) {
        rootLogger.info("Find all Fibonacci numbers in array");
        return findNumbers(array, CheckNumbers::isFibonacci);
    }

    public Array findThreeDigitNumbers(Array array) {
        rootLogger.info("Find all numbers witch are tree-digits with all unique numbers in array");
        return findNumbers(array,a -> (a > 100 && a < 999 && CheckNumbers.isAllDigitsUnique(a)));
    }

}
