package com.example.common.kit;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class BikeKit {
	/*
	 * 编号规则：共11位
		前4位——区号，不足4位用0补齐；
		中间3位——编号，自增长；
		后2位——批次号，1-99，第1批为01；
		末2位——随机数字；
		
		
		车辆编号规则变更：共11位 zyh
		前4位——区号，不足4位用0补齐，如上海为0021； 未指派
		编号具有唯一性。 未指派
		执行编辑
		中间2位——批次号，1-99，第1批为01； 未指派
		后2位——随机数字，1-99； 未指派
		末3位——编号，自增长；
	 */
	public static List<String> getBikeCode(int size){
	    List<String> listStr = new ArrayList<String>();
	    
		
		for(int n = 0; n< size; n++){
		    String s  = "0021"+"01"+getRandom(99, 2)+BikeKit.getIncrease(n);
		    System.out.println(s);
		    listStr.add(s);
		}
		return listStr;
	}
	
	public static String getIncrease(int i){
	    int temp = i+1;
	    String result = String.valueOf(temp);
	    while(result.length()<3){
	        result = "0"+result;
	    }
	    return result;
	}
	
	public static String getRandom(int max, int length){
		Random r = new Random();
		String result = String.valueOf(r.nextInt(max)) ;
	    while(result.length()<length){
	        result = "0"+result;
	    }
	    return result;
	}
	
//	public static void main(String[] args) {
//	    List<String> listStr = BikeKit.getBikeCode(55);
//	}
}
