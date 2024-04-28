package com.example.controller.generator;

import com.baomidou.mybatisplus.generator.config.*;
import org.apache.ibatis.jdbc.ScriptRunner;
import org.joda.time.LocalDate;

import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.SQLException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * 基础测试类
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class BaseGeneratorTest {

    /**
     * 执行数据库脚本
     */
    protected static void initDataSource(DataSourceConfig dataSourceConfig) throws SQLException {
        Connection conn = dataSourceConfig.getConn();
        InputStream inputStream = MySQLGeneratorTest.class.getResourceAsStream("/sql/init.sql");
        ScriptRunner scriptRunner = new ScriptRunner(conn);
        scriptRunner.setAutoCommit(true);
        scriptRunner.runScript(new InputStreamReader(inputStream));
        conn.close();
    }

    /**
     * 策略配置
     */
    protected static StrategyConfig.Builder strategyConfig() {

        return new StrategyConfig.Builder();
    }

    /**
     * 全局配置
     */
    protected static GlobalConfig.Builder globalConfig() {
        return new GlobalConfig.Builder()
                .disableOpenDir()
                .author("zyh")
                .outputDir("D:\\myspace\\workspace\\demo\\output")
                .commentDate(LocalDate.now().toString());
    }

    /**
     * 包配置
     */
    protected static PackageConfig.Builder packageConfig() {
        Map<OutputFile, String> pathInfo = new HashMap<>();

        pathInfo.put(OutputFile.xml, System.getProperty("user.dir") + "\\dao\\src\\main\\resources\\mappers");
        pathInfo.put(OutputFile.entity, System.getProperty("user.dir") + "\\dao\\src\\main\\java\\com\\example\\domain");
        pathInfo.put(OutputFile.mapper, System.getProperty("user.dir") + "\\dao\\src\\main\\java\\com\\example\\dao\\mapper");
        pathInfo.put(OutputFile.service, System.getProperty("user.dir") + "\\service\\src\\main\\java\\com\\example\\service");
        pathInfo.put(OutputFile.serviceImpl, System.getProperty("user.dir") + "\\service\\src\\main\\java\\com\\example\\service");
        pathInfo.put(OutputFile.controller, System.getProperty("user.dir") + "\\controller\\src\\main\\java\\com\\example\\controller");

        return new PackageConfig.Builder()
                .parent("com.example")
                .controller("controller")
                .entity("domain")
                .mapper("dao.mapper")
                .serviceImpl("service.impl")
                .service("service");
              //  .pathInfo(pathInfo);
    }

    /**
     * 模板配置
     */
    protected static TemplateConfig.Builder templateConfig() {
        return new TemplateConfig.Builder().disable();
    }

    /**
     * 注入配置
     */
    protected static InjectionConfig.Builder injectionConfig() {
        // 测试自定义输出文件之前注入操作，该操作再执行生成代码前 debug 查看
        return new InjectionConfig.Builder().beforeOutputFile((tableInfo, objectMap) -> {
            System.out.println("tableInfo: " + tableInfo.getEntityName() + " objectMap: " + objectMap.size());
        });
    }
}