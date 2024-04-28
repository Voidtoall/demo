package com.example.controller.generator;

import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.DataSourceConfig;
import org.junit.jupiter.api.Test;

/**
 * MySQL 代码生成
 *
 * @author lanjerry
 * @since 3.5.3
 */
public class MySQLGeneratorTest extends BaseGeneratorTest {

    /**
     * 数据源配置
     */
    private static final DataSourceConfig DATA_SOURCE_CONFIG = new DataSourceConfig
            .Builder("jdbc:mysql://localhost:3306/demo?serverTimezone=GMT%2B8&characterEncoding=utf8&useSSL=true", "zyh", "zyh081")
            .schema("demo")
            .build();

    @Test
    public void testSimple() {
        AutoGenerator generator = new AutoGenerator(DATA_SOURCE_CONFIG);
        generator.strategy(strategyConfig().build());
        generator.global(globalConfig().build());
        generator.packageInfo(packageConfig().build());
        generator.execute();
    }

}