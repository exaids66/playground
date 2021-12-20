package com.play.playground.config;


import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.PathSelectors;
import springfox.documentation.builders.RequestHandlerSelectors;
import springfox.documentation.service.ApiInfo;
import springfox.documentation.service.Contact;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;


@EnableSwagger2
@Configuration
//@EnableWebMvc
public class Swagger2Config {
    @Bean
    public Docket getDocket() {

        // 创建封面信息对象
        ApiInfoBuilder apiInfoBuilder = new ApiInfoBuilder();

        // 设置文档标题、描述、联系人
        apiInfoBuilder.title("运动场管理系统")
                .description("运动场管理系统后端文档")
                .version("v 1.0.0");
//                .contact(new Contact("Lisang", "lisang.online","2458607905@qq.com"));

        ApiInfo apiInfo = apiInfoBuilder.build();

        // 指定文档风格
        Docket docket = new Docket(DocumentationType.SWAGGER_2)
                .apiInfo(apiInfo) // 指定生成的文档中的封面信息；文档标题、版本、作者
                .select()
                .apis(RequestHandlerSelectors.basePackage("com.play.playground"))
                .paths(PathSelectors.any())
                .build();

        return docket;
    }
}
