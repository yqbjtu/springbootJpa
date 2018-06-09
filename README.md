# springboot
springboot learn

https://docs.spring.io/spring-data/jpa/docs/1.11.0.RELEASE/reference/html/  

    在Eclispe中启动之前将数据库文件src\main\resources\db\quiclcd01.sql导入到mysql数据库db1中，更改src\main\resources\application.properteis中关于数据库的连接信息，例如ip和用户名密码之类的。
  选中DemoApplication.java, run as->Java Application, 然后登录http://localhost:8080/hello    

http://127.0.0.1:8082/swagger-ui.html，可以访问到如下界面 API 介绍页面  
  或者命令行下面C:\{your-path}\springbootdb\target>java -jar demo-0.0.1-SNAPSHOT.jar   

http://127.0.0.1:8080/user/add?name=u1&email=yqbjtu@163.com  
http://127.0.0.1:8080/user/all  
http://127.0.0.1:8080/user/delete/{id}  
http://127.0.0.1:8080/user/init  
http://127.0.0.1:8080/user/find?name=xxx  
http://127.0.0.1:8080/user/findByFullName/{fullname}

mvn package -P prod  
mvn package -P test  

@Autowired
    private Environment env;
        
    @RequestMapping("/testProfile")
    public String testProfile(){
        return env.getProperty("profile");
    }

