package com.example.domain;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;
import java.util.Date;

/**
 * Created by  ZYH	 on 2024-04-21.
 */
public class BasePo {
	
	
	@Override
	public String toString() {
		StringBuilder stringBuffer = new StringBuilder();
		
		String className = this.getClass().getSimpleName();
		
		stringBuffer.append(className).append("{");
		
		Field[] fields = this.getClass().getDeclaredFields();
		
		Class ftype = null;
		Object fvalue = null;
		for(Field field : fields) 
		{
			ftype = field.getType();
			if(ftype.isPrimitive() || ftype == String.class || ftype == Integer.class
								   || ftype == Long.class   || ftype == Date.class
								   && Modifier.isStatic(ftype.getModifiers()))
			{
				field.setAccessible(true);
				try {
					fvalue = field.get(this);
				} catch (IllegalArgumentException | IllegalAccessException e) {
					e.printStackTrace();
				}
                stringBuffer.append(field.getName()).append(":").append(fvalue).append(",");
			}
		}
		stringBuffer.append("}");
		return stringBuffer.toString();
	}
	
}
