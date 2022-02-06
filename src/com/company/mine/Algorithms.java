package com.company.mine;

public class Algorithms {
    public static void main(String[] args) {
        int a = 2;
        int b = 3;
        System.out.println(addNumbers(a,b));

        int [] arr = {1,2,3,4,5};

        System.out.println(addNumbersInArray(arr));
    }
    public static int addNumbers(int a, int b){
        return a+b;
    }

    public static int addNumbersInArray(int [] arr){
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            sum +=arr[i];
        }
        return sum;
    }
}
