/*
package com.example.controller.generator;

import com.baomidou.mybatisplus.generator.config.GlobalConfig;
import com.baomidou.mybatisplus.generator.config.rules.DbColumnType;
import com.baomidou.mybatisplus.generator.config.ITypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableField;
import com.baomidou.mybatisplus.generator.config.rules.IColumnType;

public class CustomTypeConverter implements ITypeConvert {

    @Override
    public IColumnType processTypeConvert(@org.jetbrains.annotations.NotNull GlobalConfig globalConfig, @org.jetbrains.annotations.NotNull TableField tableField) {
        String dataType = field.getType().toLowerCase(); // 获取数据库中的数据类型
        // 根据数据库的数据类型转换为 Java 类型
        if (dataType.contains("varchar")) {
            return DbColumnType.STRING;
        } else if (dataType.contains("int")) {
            return DbColumnType.INTEGER;
        } else if (dataType.contains("date")) {
            return DbColumnType.LOCAL_DATE; // 映射到 Java 8 的 LocalDate
        } else if (dataType.contains("datetime")) {
            return DbColumnType.LOCAL_DATE_TIME; // 映射到 LocalDateTime
        } else if (dataType.contains("float")) {
            return DbColumnType.FLOAT;
        } else {
            // 默认返回 Object 类型
            return DbColumnType.OBJECT;
        }

        return ITypeConvert.super.processTypeConvert(globalConfig, tableField);
    }

    @Override
    public IColumnType processTypeConvert(@org.jetbrains.annotations.NotNull GlobalConfig globalConfig, @org.jetbrains.annotations.NotNull String fieldType) {
        return null;
    }
}*/
