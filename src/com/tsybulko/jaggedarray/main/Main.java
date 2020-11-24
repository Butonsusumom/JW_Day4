package com.tsybulko.jaggedarray.main;

import com.tsybulko.jaggedarray.report.JaggedReport;
import com.tsybulko.jaggedarray.service.ArraySortService;

public class Main {

    public static void main(String[] args) {
        ArraySortService sortService = new ArraySortService();
        JaggedReport report = new JaggedReport();

        int [][] twoDimArray = {{2,4,5,8,9,13},{1,4,7,11},{4,18,20,5,3},{7,4,5,10,9,12,17}};
        for (int i = 0; i < twoDimArray.length; i++) {
            for (int j = 0; j < twoDimArray[i].length; j++) {
                System.out.print(" " + twoDimArray[i][j] + " ");
            }
            System.out.println();
        }

        int [][] sortMax = sortService.sortByMax(twoDimArray);
        report.reportByMax(sortMax);
        int [][] sortMin = sortService.sortByMin(twoDimArray);
        report.reportByMin(sortMin);
        int [][] sortSum = sortService.sortBySum(twoDimArray);
        report.reportBySum(sortSum);
    }

}
