package com.example.demo.exam;

import java.util.Arrays;
import java.util.stream.Collectors;

public class IPQuestion {
    public static void main(String[] args) {
/*        System.out.println(Integer.toHexString(128));
        System.out.println(Long.parseLong(Integer.toHexString(128), 16));*/

        String s= "128#0#255#255";
        Integer[] irr = Arrays.stream(s.split("#"))
                .map(Integer::parseInt).toArray(Integer[]::new);
        StringBuilder sb = new StringBuilder();

        System.out.println(Arrays.toString(irr));
        Arrays.stream(irr).forEach(x->{
            String tempStr = Integer.toBinaryString(x);
            if(tempStr.length() < 8){
                while(tempStr.length() < 8){
                    tempStr = "0"+tempStr;
                }
            }
            sb.append(tempStr);
            System.out.println(x);
            System.out.println(tempStr);
        });
        System.out.println(sb.toString());
        System.out.println(Long.parseLong(sb.toString(), 2));
    }
}
