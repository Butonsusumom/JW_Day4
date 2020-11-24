package com.tsybulko.arraycontainer.main;

import com.tsybulko.arraycontainer.entity.Array;
import com.tsybulko.arraycontainer.report.ArrayContainerReport;
import com.tsybulko.arraycontainer.report.ExceptionReport;
import com.tsybulko.arraycontainer.util.ArrayGenerators;

import java.io.FileNotFoundException;

public class Main {
    public static void main(String[] args) {
        ArrayContainerReport report = new ArrayContainerReport();
        ArrayGenerators arrayGenerator = new ArrayGenerators();
        try {
            Array array = arrayGenerator.readFile("C:\\Users\\KSU\\Java Web 2020\\Day4\\target\\array.txt");
            report.arrayFromFile(array);
        }
        catch (FileNotFoundException exception)
        {
            ExceptionReport exceptionReport = new ExceptionReport();
            exceptionReport.fileNotFound(exception.getMessage());
        }
        Array randomArray = arrayGenerator.randomNumbers(10,100);
        report.randomArray(randomArray);
    }
}
