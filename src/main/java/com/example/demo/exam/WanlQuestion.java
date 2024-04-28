package com.example.demo.exam;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class WanlQuestion {

    public static void main(String[] args) {
      //  Scanner sc = new Scanner(System.in);
        //1,3,4,6,8-20
        String str = "1,8-20,6,3,4";
        String[] vlanArr = str.split(",");

      //  System.out.println(Arrays.toString(vlanArr));
      //  LinkedList<Integer[]> vlanList = new LinkedList<>();
        int remove = 29;//Integer.parseInt(sc.nextLine());
        System.out.println(apply(remove, vlanArr));
    }

    public static void addResult(ArrayList<Integer[]> resultList, Integer[] x){
        if(x.length > 1 && x[0] - x[1] == 0){
           Integer[] tt =  new Integer[1];
           tt[0] = x[0];
           resultList.add(tt);
        }else {
            resultList.add(x);
        }

    }

   private static String apply (int remove, String[] vlanArr){
       List<String[]> ss = Arrays.stream(vlanArr).map(v-> v.split("-")).collect(Collectors.toList());
       List<Integer[]> sList = new ArrayList<>();
       for(String[] rr: ss){
           // System.out.println(Arrays.toString(rr));
           Comparator<Integer> comparator1 = Comparator.comparing(Integer::intValue);
           Integer[] sArr = Arrays.stream(rr).map(Integer::parseInt).toArray(Integer[]::new);
           sList.add(sArr);
       }

       LinkedList<Integer[]> sortList = sList.stream().sorted((a,b)->a[0]-b[0]).collect(Collectors.toCollection(LinkedList<Integer[]>::new));
       sortList.stream().forEach(x-> System.out.println(Arrays.toString(x)));

       ArrayList<Integer[]> resultList = new ArrayList<>();
       sortList.forEach(x->{
           if(x.length == 1){
               if(x[0] != remove){
                   addResult(resultList,x);
               }
           }else if(x.length > 1){
               if(remove == x[0]){
                   x[0] = remove+1;
                   addResult(resultList,x);
               }else if( remove == x[1]){
                   x[1] = remove-1;
                   addResult(resultList,x);
               }else if(x[0]< remove && remove < x[1]){
                   Integer[] arrMin = new Integer[2];
                   Integer[] arrMax = new Integer[2];

                   arrMin[0] = x[0];
                   arrMin[1] = remove-1;

                   arrMax[0] = remove+1;
                   arrMax[1] = x[1];
                   addResult(resultList,arrMin);
                   addResult(resultList,arrMax);
               }else {
                   addResult(resultList,x);
               }
           }

       });
        StringBuilder sb = new StringBuilder();
        resultList.forEach(xx->{
            if(xx.length == 1){
                sb.append(","+xx[0]);
            } else {
                sb.append(","+xx[0]+"-"+xx[1]);
            }
        });
       return sb.replace(0,1,"").toString();
    }
}
