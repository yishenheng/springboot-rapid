import com.baomidou.mybatisplus.annotation.DbType;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.generator.AutoGenerator;
import com.baomidou.mybatisplus.generator.InjectionConfig;
import com.baomidou.mybatisplus.generator.config.*;
import com.baomidou.mybatisplus.generator.config.converts.MySqlTypeConvert;
import com.baomidou.mybatisplus.generator.config.po.TableInfo;
import com.baomidou.mybatisplus.generator.config.rules.NamingStrategy;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/**
 * @author yishenheng
 * @date 2020-05-24 10:43
 */
public class GenerateBean {

    private static final String DRIVER_CLASS_NAME = "com.mysql.cj.jdbc.Driver";
    private static final String DATASOURCE_USERNAME = "root";
    private static final String DATASOURCE_PASWORD = "Ysh0113.";
    private static final String DATASOUORCE_URL = "jdbc:mysql://localhost:3306/ysh-test";


    public static void main(String[] args) {
        String[] tables = {"user"};
        String projectName = "/";
        // 代码生成器
        AutoGenerator mpg = new AutoGenerator().setGlobalConfig(
                // 全局配置
                new GlobalConfig()
                        .setOutputDir(getRootPath() + projectName + "/src/main/java")//输出目录
                        .setFileOverride(true)// 是否覆盖文件
                        .setActiveRecord(true)// 开启 activeRecord 模式
                        .setEnableCache(false)// XML 二级缓存
                        .setBaseResultMap(true)// XML ResultMap
                        .setBaseColumnList(true)// XML columList
                        .setAuthor("yishenheng")
                        .setIdType(IdType.ID_WORKER)
                        .setServiceName("%sService")
                        .setSwagger2(true)
        ).setDataSource(
                // 数据源配置
                new DataSourceConfig()
                        .setDbType(DbType.MYSQL)// 数据库类型
                        .setTypeConvert(new MySqlTypeConvert() {

                        })
                        .setDriverName(DRIVER_CLASS_NAME)
                        .setUsername(DATASOURCE_USERNAME)
                        .setPassword(DATASOURCE_PASWORD)
                        .setUrl(DATASOUORCE_URL)
        ).setStrategy(
                // 策略配置
                new StrategyConfig()
                        .setTablePrefix("")// 此处可以修改为您的表前缀
                        .setNaming(NamingStrategy.underline_to_camel)// 表名生成策略
                        .setInclude(tables) // 需要生成的表
                        .setEntityLombokModel(true)
                        .setEntityBooleanColumnRemoveIsPrefix(true) //Boolean类型字段是否移除is前缀处理
                        .setRestControllerStyle(true)
        ).setPackageInfo(
                // 包配置
                new PackageConfig()
                        .setParent("com.yishenheng.rapid")// 自定义包路径
                        .setController("controller")// 这里是控制器包名，默认 web
        ).setCfg(
                // 注入自定义配置，可以在 VM 中使用 cfg.abc 设置的值
                new InjectionConfig() {
                    @Override
                    public void initMap() {
                        Map<String, Object> map = new HashMap<>();
                        this.setMap(map);
                    }
                }.setFileOutConfigList(Collections.<FileOutConfig>singletonList(new FileOutConfig("/templates/mapper.xml.vm") {
                    // 自定义输出文件目录
                    @Override
                    public String outputFile(TableInfo tableInfo) {
                        return getRootPath() + projectName + "/src/main/resources/mappers/" + tableInfo.getEntityName() + "Mapper.xml";
                    }
                }))
        );

        // 执行生成
        mpg.execute();

    }

    /**
     * 获取项目根路径
     *
     * @return 项目路径
     */
    private static String getRootPath() {
        File directory = new File("");// 参数为空
        String courseFile = null;
        try {
            courseFile = directory.getCanonicalPath();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return courseFile;
    }
}
