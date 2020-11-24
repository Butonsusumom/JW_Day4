package com.tsybulko.arraycontainer.util;

import com.tsybulko.arraycontainer.entity.Array;
import org.apache.logging.log4j.LogManager;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Random;
import java.util.Scanner;
import java.util.logging.Logger;

public class ArrayGenerators {
    static final Logger rootLogger = (Logger) LogManager.getRootLogger();

    public Array randomNumbers(int size, int max){
        rootLogger.info("Initialize array with random numbers");
        Random random = new Random();
        Array array = new Array();
        while(size-- != 0){
            int value = random.nextInt(max);
            array.add(value);
        }
        return array;
    }

    public Array randomNumbers(int size){
        rootLogger.info("Initialize array with random numbers");
        Random random = new Random();
        Array array = new Array();
        while(size-- != 0){
            int value = random.nextInt();
            array.add(value);
        }
        return array;
    }

    public Array readConsole(){
        rootLogger.info("Initialize array from console");
        Scanner consoleScanner = new Scanner(System.in);
        Array array = new Array();
        int size = consoleScanner.nextInt();
        while (size-- != 0){
            int value = consoleScanner.nextInt();
            array.add(value);
        }
        return array;
    }

    public Array readFile(String fileName) throws FileNotFoundException {
        rootLogger.info("Initialize array from file");
        File file = new File(fileName);
        Scanner fileScanner = new Scanner(file);
        Array array = new Array();
        while (fileScanner.hasNextInt()){
            array.add(fileScanner.nextInt());
        }
        fileScanner.close();
        return array;
    }


}
