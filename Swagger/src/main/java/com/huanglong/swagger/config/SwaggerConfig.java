package com.huanglong.swagger.config;

import io.swagger.annotations.Api;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.core.env.Profiles;
import springfox.documentation.RequestHandler;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.service.VendorExtension;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.ArrayList;

/**
 *  @author: huanglong
 *  @Date: 2021/7/23 11:36
 *  @Description:
 */
@Configuration
@EnableSwagger2   // 开启Swagger2
public class SwaggerConfig {

    // api接口包扫描路径
    public static final String SWAGGER_SCAN_BASE_PACKAGE = "com.huanglong.swagger.Ctrl.Hello";

    // api版本
    public static final String VISION = "1.0.0";


    // 配置多个组,是为了把test和开发分开
    @Bean
    public Docket groupRestApi() {
        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apinfo2()).
                groupName("用户模块API文档").
                select().
                apis(RequestHandlerSelectors.basePackage("com.huanglong.swagger.Ctrl.User")).build();
    }


    // 配置Swagger的Bean实例对象Docket
    @Bean
    public Docket createRestApi(Environment environment) {  // Environment 获得项目中的环境
        //  设置当前项目的Swagger环境
        boolean a = environment.acceptsProfiles(Profiles.of("dev", "test"));

        return new Docket(DocumentationType.SWAGGER_2).
                apiInfo(apinfo()).
                groupName("测试案例API文档").
                useDefaultResponseMessages(false).   // 去掉swagger默认的状态码只保留200状态码(可选，不是必要加的条件)
                enable(a).     // 确定是否开启Swagger，为true的时候开启,false为不开启
                select().
                apis(RequestHandlerSelectors.basePackage(SWAGGER_SCAN_BASE_PACKAGE)).  // RequestHandlerSelectors配置要扫描的方式，主要有any(扫描全部)、none(不扫描)、withclassAnnotation(扫描类上的注解，参数一个注解的反射对象)、withMethodAnnotation(扫描方法上的注解)、baspackage(本案列是基于包扫描的方式)
                paths(PathSelectors.any()).  // 过滤什么路径
                build();
    }


    //  配置Swagger信息的apiInfo
    private ApiInfo apinfo() {
        return new ApiInfo(
                "单证核销API文档",       // Api文档标题
                "对于单证核销接口开发的规范",    // 详细描述
                VISION,      // 版本
                "http://www.baidu.com",     // 服务组织的url
                new Contact("黄龙", "http://www.baidu.com", "2069321663@qq.com"),    // 作者
                "Apache 2.0",
                "http://www.apache.org/licenses/LICENSE-2.0",
                new ArrayList<VendorExtension>());
    }


    // 使用工厂模式生产ApiInfo
    private ApiInfo apinfo2() {
        return new ApiInfoBuilder().
                title("用户操作Api").   // Api文档标题
                description("对用户操作的Api描述"). // 详细描述
                version(VISION).   // 版本号
                termsOfServiceUrl("http://www.baidu.com").  // 服务组织url
                contact(new Contact("黄龙", "http://www.baidu.com", "2069321663@qq.com")). //作者
                license("Apache 2.0").
                licenseUrl("http://www.apache.org/licenses/LICENSE-2.0").
                build();
      }

}
