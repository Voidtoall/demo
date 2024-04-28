package com.example.demo.exam;

import java.util.Arrays;
import java.util.HashMap;

public class quanzhongpaixu {
    public static void main(String[] args) {
        Integer[] arrs = {1,3,5,7,9};
        Integer[] arrsWeight = {6,3,2,9,1};
        Integer[] result = arrs;

        for (int i = 0; i < arrsWeight.length-1; i++) {
            for (int j = i; j < arrsWeight.length-1; j++) {
                if(arrsWeight[i] < arrsWeight[j+1]){
                    //交换 倒序排列
                    Integer temp = arrsWeight[i];
                    arrsWeight[i]  = arrsWeight[j+1];
                    arrsWeight[j+1] = temp;

                    Integer temp2 = result[i];
                    result[i]  = result[j+1];
                    result[j+1] = temp2;
                }
            }
        }
        System.out.println(Arrays.toString(arrsWeight));
        System.out.println(Arrays.toString(result));
    }
}
