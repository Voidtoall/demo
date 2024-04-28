package com.example.demo.exam;

import java.util.Arrays;

public class CalMaxShow {

    public static void main(String[] args) {
        int n = 2;
        int[][] initData = {{720,120},{820,120},{450,670},{450,100}};

        for (int i = 0; i < n; i++) {
           int res = getResult(i,initData);
            System.out.println(res);
        }
    }

    private static int getResult(int i, int[][] initData) {
        Arrays.sort(initData,(a,b)->a[1]-b[1]);
        int resT = 1;
        int t = initData[1][0];

        for (int j = 0; j < initData.length; j++) {
            int startT = initData[j][0];
            int l = initData[j][1];
            if(t-(startT +l) >= 15){
                resT++;
                t = startT;
            }
        }
        return resT;
    }
}
