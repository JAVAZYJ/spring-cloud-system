package com.example.spring.cloud.client.generator;

import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.FieldFill;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.po.TableFill;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;
import lombok.Data;

import java.util.ArrayList;

/**
 * 代码生成器
 * @author YiJieZhu
 * @since 2019年6月13日 09点39分
 */
public class CodeGenerateTest {

    public static void main(String[] args) {
        GenerateParams generateParams = new GenerateParams();
        generateParams.setAuthor("YiJieZhu");
        generateParams.setOutputDirectory("D:/Development_Software/WorkSpaces/spring-cloud-system/spring-cloud-client/src/main/java");
        generateParams.setJdbcDriver("com.mysql.cj.jdbc.Driver");
        generateParams.setJdbcUserName("root");
        generateParams.setJdbcPassword("root");
        generateParams.setJdbcUrl("jdbc:mysql://localhost:3306/spring_cloud_system?characterEncoding=utf8&serverTimezone=GMT");
        generateParams.setParentPackage("com.example.spring.cloud.client");
        generateParams.setGeneratorInterface(true);
        generateParams.setIncludeTables(new String[]{"user"});
        generateParams.setEntityName("%s");
        SimpleGenerator.doGeneration(generateParams);
    }

    @Data
    public static class GenerateParams {

        //生成代码里，注释的作者
        private String author = "YiJieZhu";

        //代码生成输出的目录，可为项目路径的相对路径
        private String outputDirectory = "D:/Development_Software/WorkSpaces/spring-cloud-system/spring-cloud-client/src/main/java";

        //jdbc驱动
        private String jdbcDriver = "com.mysql.cj.jdbc.Driver";

        //数据库连接地址
        private String jdbcUrl = "jdbc:mysql://localhost:3306/spring_cloud_system?characterEncoding=utf8&serverTimezone=GMT";

        //数据库账号
        private String jdbcUserName = "root";

        //数据库密码
        private String jdbcPassword = "root";

        //去掉表的前缀
        private String[] removeTablePrefix = {"xx_"};

        //代码生成包含的表，可为空，为空默认生成所有
        private String[] includeTables={"user"};

        //代码生成的类的父包名称
        private String parentPackage = "com.example.spring.cloud.client";

        //service是否生成接口，这个根据自己项目情况决定
        private Boolean generatorInterface = true;

        private String entityName;

    }

    public static class SimpleGenerator {

        public static void doGeneration(GenerateParams generateParams) {

            AutoGenerator mpg = new AutoGenerator();

            // 全局配置
            GlobalConfig gc = new GlobalConfig();
            gc.setOutputDir(generateParams.getOutputDirectory());
            gc.setFileOverride(true);
            gc.setActiveRecord(false);
            gc.setBaseResultMap(true);
            gc.setBaseColumnList(true);
            gc.setEnableCache(false);
            gc.setOpen(false);
            gc.setAuthor(generateParams.getAuthor());
            gc.setEntityName(generateParams.getEntityName());

            // 自定义文件命名，注意 %s 会自动填充表实体属性！
            if (generateParams.getGeneratorInterface()) {
                gc.setServiceName("%sService");
                gc.setServiceImplName("%sServiceImpl");
            } else {
                gc.setServiceName("%sService");
                gc.setServiceImplName("%sService");
            }
            mpg.setGlobalConfig(gc);

            // 数据源配置
            DataSourceConfig dsc = new DataSourceConfig();
            dsc.setDbType(DbType.MYSQL);
            dsc.setDriverName(generateParams.getJdbcDriver());
            dsc.setUrl(generateParams.getJdbcUrl());
            dsc.setUsername(generateParams.getJdbcUserName());
            dsc.setPassword(generateParams.getJdbcPassword());
            mpg.setDataSource(dsc);

            // 策略配置
            StrategyConfig strategy = new StrategyConfig();
            strategy.setCapitalMode(false);
            strategy.setLogicDeleteFieldName("del_flag");
            strategy.setEntityTableFieldAnnotationEnable(true);

            // 此处可以移除表前缀表前缀
            //strategy.setTablePrefix(generateParams.getRemoveTablePrefix());

            // 表名生成策略
            strategy.setNaming(NamingStrategy.underline_to_camel);
            strategy.setColumnNaming(NamingStrategy.underline_to_camel);

            // 需要生成的表
            strategy.setInclude(generateParams.getIncludeTables());

            // 公共字段填充
            ArrayList<TableFill> tableFills = new ArrayList<>();
            tableFills.add(new TableFill("CREATE_TIME", FieldFill.INSERT));
            tableFills.add(new TableFill("UPDATE_TIME", FieldFill.UPDATE));
            tableFills.add(new TableFill("CREATE_USER", FieldFill.INSERT));
            tableFills.add(new TableFill("UPDATE_USER", FieldFill.UPDATE));
            strategy.setTableFillList(tableFills);

            mpg.setStrategy(strategy);

            // 自定义模板配置，可以 copy 源码 mybatis-plus/src/main/resources/templates 下面内容修改，
            // 放置自己项目的 src/main/resources/templates 目录下, 默认名称一下可以不配置，也可以自定义模板名称
            TemplateConfig tc = new TemplateConfig();
            tc.setController(null);

            if (!generateParams.getGeneratorInterface()) {
                tc.setService(null);
                tc.setServiceImpl("/templates/NoneInterfaceServiceImpl.java");
            }

            //如上任何一个模块如果设置 空 OR Null 将不生成该模块。
            mpg.setTemplate(tc);

            // 包配置
            PackageConfig pc = new PackageConfig();
            pc.setParent(generateParams.getParentPackage());
            pc.setModuleName("");
            pc.setXml("mapper.mapping");

            if (generateParams.getGeneratorInterface()) {
                pc.setServiceImpl("service.impl");
                pc.setService("service");
            } else {
                pc.setServiceImpl("service");
                pc.setService("service");
            }

            mpg.setPackageInfo(pc);


            // 执行生成
            mpg.execute();
        }

        public static void main(String[] args) {
            doGeneration(new  GenerateParams() );
        }

    }

}
