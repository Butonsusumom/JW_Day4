package com.tsybulko.arraycontainer.util;

public class CheckNumbers {

    public static boolean isSimple (int number) {
        number = Math.abs(number);
        for (int i = 2; i <= number/2; i++){
            if (number % i == 0)
                return false;
        }
        return true;
    }

    public static boolean isFibonacci(int value) {
        int prevValue = 1;
        int currValue = 1;
        while (value > currValue){
            int tempCurValue = currValue;
            currValue = prevValue + currValue;
            prevValue = tempCurValue;
        }
        return value == currValue;
    }

    public static boolean isAllDigitsUnique(int value) {
        String strValue = String.valueOf(value);
        if (strValue.length() == 1){
            return true;
        }
        boolean unique = true;
        for(int i = 0; i < strValue.length() - 1; i++){
            for (int j = i + 1; j < strValue.length(); j++){
                if (strValue.charAt(i) == strValue.charAt(j)){
                    unique = false;
                    break;
                }
            }
        }
        return unique;
    }

}
