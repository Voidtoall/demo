package com.example.demo.exam;

import org.springframework.boot.SpringBootExceptionReporter;

import java.util.*;
import java.util.stream.Collector;
import java.util.stream.Collectors;

public class Pailiezuhe {

   public static final Stack<String> res = new Stack<>();
   public static final List<String> resultList = new ArrayList<>();
    public static void main(String[] args) {
         int n = 3;
         String[] arr = {"a","b","c","d"};
     //   Arrays.sort(arr);

        permut(arr,4,0,0);

      //  System.out.println(resultList.toString());
    }

    private static void permut(String[] arr, int targ, int has, int cur) {
        if(cur == targ){
           // System.out.println(res);
            resultList.add(res.stream().toList().toString());
            return;
        }

        for (int i = 0; i < arr.length ; i++) {
            if(!res.contains(arr[i])){
                res.add(arr[i]);
                permut(arr,targ,has,cur+1);
                System.out.println(res);
                res.pop();
                System.out.println(res);
            }
        }
    }
}
