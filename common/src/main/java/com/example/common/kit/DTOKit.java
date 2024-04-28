package com.example.common.kit;

import java.lang.reflect.Field;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class DTOKit {
	
	/*
	 * 请保证属性的名字 一样
	 * */
	@SuppressWarnings("unchecked")
	public static <T>T convert(Object fromObj, Object toObj){
		if(fromObj == null || toObj == null)
			return null;
		Field[] fromFields = getAllFields(fromObj.getClass());
		Field[] toFields = getAllFields(toObj.getClass());
		try {
			for(Field f : toFields){
				f.setAccessible(true);
				for(Field f2 : fromFields){
					f2.setAccessible(true);
					if(f.getName().equals(f2.getName())){
						f.set(toObj, f2.get(fromObj));
					}
				}
			}
			return (T) toObj;
		} catch (SecurityException e) {
			e.printStackTrace();
		} catch (IllegalArgumentException e) {
			e.printStackTrace();
		} catch (IllegalAccessException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	@SuppressWarnings("unchecked")
	public static <T> List<T> convertList(List<?> fromList, Class<?> classz){
		Object[] objs = new Object[fromList.size()];
		for(int i = 0; i<fromList.size();i++){
			try {
				objs[i] = DTOKit.convert(fromList.get(i), classz.newInstance());
			} catch (InstantiationException e) {
				e.printStackTrace();
			} catch (IllegalAccessException e) {
				e.printStackTrace();
			}
		}
		return (List<T>) Arrays.asList(objs);
	}
	
	public static Map<String,Object> convertObjToMap(Object fromObj){
		if(fromObj == null)
			return null;
		
		Map<String,Object> m = new HashMap<String,Object>();
		Field[] fields = fromObj.getClass().getDeclaredFields();
			for(Field f : fields){
				try {
					f.setAccessible(true);
					m.put(f.getName(), f.get(fromObj));
				} catch (IllegalArgumentException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (IllegalAccessException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
				
		return m;
	}
	
	@SuppressWarnings("rawtypes")
	public static Field[] getAllFields(final Class classz){
		//获取size
		int i = 0 ;
		Class initClass = classz;
		do{
			i += initClass.getDeclaredFields().length;
			initClass = initClass.getSuperclass();
		}
		while(initClass != null);
		
		Field [] fields = new Field[i];
		int k = i;
		
		initClass = classz;
		do{
			for(Field f : initClass.getDeclaredFields()){
				fields[k-1] = f;
				k --;
			}
				
			initClass = initClass.getSuperclass();
			
		}
		while(initClass != null);
		
		return fields;
	}
	
}
