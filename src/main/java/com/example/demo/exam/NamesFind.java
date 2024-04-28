package com.example.demo.exam;

public class NamesFind {

    public static void main(String[] args) {
        String str = "zhang san,zhang ar san,zhang san  san";
        String ss = "zhas";

        char[] ssChar = ss.toCharArray();
        String[] strArr = str.split(",");
        boolean res = false;
        for (int j = 0; j < strArr.length; j++) {
            int index =  strArr[j].indexOf(ssChar[0]);
            if(index == 0){
                for (int i = 1; i < ssChar.length; i++) {
                    String[] name = strArr[j].split(" ");
                    if(name.length == ssChar.length && name[i].indexOf(ssChar[i]) == 0){
                        res = true;
                    }else if(name[i-1].length() > i &&name[i-1].indexOf(ss.substring(0,i)) == 0){
                        res = true;
                    }else{
                        res = false;
                    }

                }
                if(res){
                    System.out.println(strArr[j]);
                    break;
                }

            }

        }

    }

}
