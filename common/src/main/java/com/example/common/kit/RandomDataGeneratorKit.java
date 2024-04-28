package com.example.common.kit;

import cn.hutool.core.lang.generator.UUIDGenerator;
import org.joda.time.LocalDate;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.Random;

public class RandomDataGeneratorKit {
    // 一个随机数生成器
    private static final Random RANDOM = new Random();

    // 为对象生成随机数据并返回
    public static <T> T generateRandomData(T object) {
        // 获取对象的所有字段（属性）
        Field[] fields = object.getClass().getDeclaredFields();

        for (Field field : fields) {
            try {
                // 设置字段为可访问，以便我们可以修改其值
                field.setAccessible(true);

                // 获取字段的类型
                Class<?> fieldType = field.getType();
                // 根据字段的类型生成随机数据
                Object randomValue = generateRandomValue(fieldType);

                // 将随机数据赋给对象的字段
                field.set(object, randomValue);

            } catch (IllegalAccessException e) {
                System.err.println("无法访问字段：" + field.getName());
                //e.printStackTrace();
            }
        }
        return object; // 返回更新后的对象
    }

    // 根据字段的类型生成随机数据
    private static Object generateRandomValue(Class<?> fieldType) {
        if (fieldType == int.class || fieldType == Integer.class) {
            return RANDOM.nextInt(100); // 生成 0-99 之间的随机整数
        } else if (fieldType == long.class || fieldType == Long.class) {
            return Math.abs(RANDOM.nextLong()); // 生成随机 long 数值
        } else if (fieldType == double.class || fieldType == Double.class) {
            return RANDOM.nextDouble(); // 生成随机 double 数值
        } else if (fieldType == boolean.class || fieldType == Boolean.class) {
            return RANDOM.nextBoolean(); // 生成随机 boolean 值
        } else if (fieldType == String.class) {
            return new UUIDGenerator().next(); // 生成随机字符串
        } else {
            return null; // 如果不支持的类型，返回 null
        }
    }
}

