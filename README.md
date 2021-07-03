# project
### Config
1. Logical delete
config
``` java
    @Bean
    public ISqlInjector sqlInjector() {
        return new LogicSqlInjector();
    }
```
pojo
``` java
    @TableLogic
    private Boolean isDeleted;
```
### Swagger interface test
1. Create maven under main project
2. Create swagger
``` java
@Configuration
@EnableSwagger2
public class SwaggerConfig {
    @Bean
    public Docket webApiConfig(){

        return new Docket(DocumentationType.SWAGGER_2)
                .groupName("webApi")
                .apiInfo(webApiInfo())
                .select()
                .paths(Predicates.not(PathSelectors.regex("/admin/.*")))
                .paths(Predicates.not(PathSelectors.regex("/error.*")))
                .build();

    }

    private ApiInfo webApiInfo(){

        return new ApiInfoBuilder()
                .title("网站-课程中心API文档")
                .description("本文档描述了课程中心微服务接口定义")
                .version("1.0")
                .contact(new Contact("Helen", "http://atguigu.com", "55317332@qq.com"))
                .build();
    }
}
```
3. Add dependency to test maven pom
4. Add @ComponentScan(basePackages = {"com.shun"})
5. url(http://localhost:8001/swagger-ui.html)
