package com.tsybulko.arraycontainer.report;

public class ExceptionReport {
    public void fileNotFound(String message){
        System.out.println("File not found exception: " + message);
    }
}
