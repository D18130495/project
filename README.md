# project
### primary key snowflake
``` java 
    @TableId(value = "id", type = IdType.ID_WORKER_STR)
    private String id;
```

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
2. Pagination(limit)
config
``` java
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        return new PaginationInterceptor();
    }
```

### Handler
pojo
``` java
    @TableField(fill = FieldFill.INSERT)
    private Date gmtCreate;

    @TableField(fill = FieldFill.INSERT_UPDATE)
    private Date gmtModified;
```
handler
``` java
    public class MyMetaObjectHandler implements MetaObjectHandler {
    public void insertFill(MetaObject metaObject) {
        this.setFieldValByName("gmtCreate", new Date(), metaObject);
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }

    public void updateFill(MetaObject metaObject) {
        this.setFieldValByName("gmtModified", new Date(), metaObject);
    }
}
```
Add @ComponentScan(basePackages = {"com.shun"}) under @SpringBootApplication

### Exception handler
``` java
    @RestControllerAdvice
    public class GlobalExceptionHandler{
        @ExceptionHandler(Exception.class)
        public R error(Exception e) {
            e.printStackTrace();
            return R.error().message("执行了全局异常处理器");
        }
    }
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
4. Add @ComponentScan(basePackages = {"com.shun"}) under @SpringBootApplication
5. url(http://localhost:8001/swagger-ui.html)

### Unified return interface
1. Create maven under main project
2. Create utils
3. Create interface and class
``` java
    public interface ResultCode {
    public static Integer SUCCESS = 20000;
    public static Integer ERROR = 20001;
}
```
``` java
public class R {
    private Boolean success;
    private Integer code;
    private String message;
    private Map<String, Object> data = new HashMap<>();

    private R() {}

    public static R ok(){
        R r = new R();
        r.setSuccess(true);
        r.setCode(ResultCode.SUCCESS);
        r.setMessage("成功");
        return r;
    }

    public static R error(){
        R r = new R();
        r.setSuccess(false);
        r.setCode(ResultCode.ERROR);
        r.setMessage("失败");
        return r;
    }

    public R success(Boolean success){
        this.setSuccess(success);
        return this;
    }

    public R message(String message){
        this.setMessage(message);
        return this;
    }

    public R code(Integer code){
        this.setCode(code);
        return this;
    }

    public R data(String key, Object value){
        this.data.put(key, value);
        return this;
    }

    public R data(Map<String, Object> map){
        this.setData(map);
        return this;
    }
```
3. Add dependency to test maven pom
4. Use swagger to test

### Pagination(limit)
``` java
    @GetMapping("/pageTeacher/{current}/{limit}")
    public R pageListTeacher(@PathVariable Integer current, @PathVariable Integer limit) {
        Page<EduTeacher> pageTeacher = new Page<EduTeacher>(current, limit);
        eduTeacherService.page(pageTeacher, null);

        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();

        return R.ok().data("total",total).data("list", records);
    }
```

### Query by condition
``` java
    PostMapping("/pageTeacherCondition/{current}/{limit}")
    public R pageListTeacherCondition(@PathVariable Integer current,
                                      @PathVariable Integer limit,
                                      @RequestBody(required = false) TeacherQuery teacherQuery) {
        Page<EduTeacher> pageTeacher = new Page<EduTeacher>(current, limit);
        QueryWrapper<EduTeacher> wrapper = new QueryWrapper<>();

        String name = teacherQuery.getName();
        Integer level = teacherQuery.getLevel();
        String begin = teacherQuery.getBegin();
        String end = teacherQuery.getEnd();

        if(!StringUtils.isEmpty(name)) {
            wrapper.like("name", name);
        }
        if(level != null) {
            wrapper.eq("level", level);
        }
        if(!StringUtils.isEmpty(begin)) {
            wrapper.ge("gmt_create", begin);
        }
        if(!StringUtils.isEmpty(end)) {
            wrapper.le("gmt_modified", end);
        }

        eduTeacherService.page(pageTeacher, wrapper);

        long total = pageTeacher.getTotal();
        List<EduTeacher> records = pageTeacher.getRecords();
        return R.ok().data("total",total).data("list", records);
    }
```