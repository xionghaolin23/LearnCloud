要将Client模块下的application.yml文件改为bootstrap.yml，删掉application.yml这是很关键的

因为bootstrap.yml是比application.yml先加载的。bootstrap.yml优先级高于application.yml

appllication.yml是用户级的资源配置项

bootstrap.ym1是系统级的，优先级更加高

SpringCloud会创建一个"Bootstrap Context"作为Spring应用的ApplicationContext的父上下文。初始化的时候，Bootstrap Context负责从外部源加载配置属性并解析配置。这两个上下文共享一个从外部获取的Environment

Bootstrap 属性有高优先级，默认情况下，它们不会被本地配置覆盖。BootstrapContext和ApplicationContext、有着不同的约定，所以新增了一个bootstrap.yml文件，保证BootstrapContext和ApplicationContext配置的分离。


动态刷新
问题：

Linux运维修改GitHub上的配置文件内容做调整：比如修改config-dev.yml提交
刷新3344，发现ConfigServer服务端配置中心立刻响应，得到最新值了
刷新3355，发现ConfigClient客户端没有任何响应，拿到的还是旧值
客户端3355没有变化除非自己重启或者重新加载，才能拿到最新值
难到每次运维修改配置文件，客户端都需要重启？？噩梦

注意：=======
就是github上面配置更新了，config Server 项目上是动态更新的，但是，client端的项目中的配置，目前还是之前的，它不能动态更新，必须重启才行。

配置
    client端一定要有actuator依赖：
        <dependency>
        <groupId>org.springframework.boot</groupId>
        <artifactId>spring-boot-starter-actuator</artifactId>
        </dependency>
    bootstrap.yml文件中新增
        # 暴露监控端点
        management:
        endpoints:
        web:
        exposure:
        include: "*"
    在controller 上添加注解
        @RefreshScope：

到此为止，配置已经完成，但是测试客户端 localhost:3355/configInfo 仍然不能动态刷新，还是旧值（也就是说环境变量里的还是旧值），需要下一步。
解决方案：===========
向 client 端发送一个 POST 请求
如 curl -X POST “http://localhost:3355/actuator/refresh”

两个必须：1.必须是 POST 请求，2.请求地址：http://localhost:3355/actuator/refresh
—