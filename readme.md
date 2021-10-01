##什么是微服务架构
![img_1.png](img_1.png)
SpringCloud 是微服务一站式服务解决方案，微服务全家桶。它是微服务开发的主流技术栈。它采用了名称，而非数字版本号。

SpringCloud 和 springCloud Alibaba 目前是最主流的微服务框架组合
版本选择：

>选用 springboot 和 springCloud 版本有约束，不按照它的约束会有冲突。
> cloud版本决定了boot版本


查看版本对应关系：https://start.spring.io/actuator/info

```json
{
  "git": {
    "branch": "9f6099852d28f3626d110706391bdad6f34c4580",
    "commit": {
      "id": "9f60998",
      "time": "2021-09-29T06:11:16Z"
    }
  },
  "build": {
    "version": "0.0.1-SNAPSHOT",
    "artifact": "start-site",
    "versions": {
      "spring-boot": "2.5.5",
      "initializr": "0.11.1-SNAPSHOT"
    },
    "name": "start.spring.io website",
    "time": "2021-09-29T06:12:02.820Z",
    "group": "io.spring.start"
  },
  "bom-ranges": {
    "azure": {
      "3.2.0": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
      "3.5.0": "Spring Boot >=2.4.0.M1 and <2.5.0-M1",
      "3.6.1": "Spring Boot >=2.5.0.M1 and <2.6.0-M1"
    },
    "codecentric-spring-boot-admin": {
      "2.4.3": "Spring Boot >=2.3.0.M1 and <2.6.0-M1"
    },
    "solace-spring-boot": {
      "1.1.0": "Spring Boot >=2.3.0.M1 and <2.6.0-M1"
    },
    "solace-spring-cloud": {
      "1.1.1": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
      "2.1.0": "Spring Boot >=2.4.0.M1 and <2.6.0-M1"
    },
    "spring-cloud": {
      "Hoxton.SR12": "Spring Boot >=2.2.0.RELEASE and <2.4.0.M1",
      "2020.0.4": "Spring Boot >=2.4.0.M1 and <2.5.6-SNAPSHOT",
      "2020.0.5-SNAPSHOT": "Spring Boot >=2.5.6-SNAPSHOT and <2.6.0-M1",
      "2021.0.0-M1": "Spring Boot >=2.6.0.M1 and <2.6.0-SNAPSHOT",
      "2021.0.0-SNAPSHOT": "Spring Boot >=2.6.0-SNAPSHOT"
    },
    "spring-cloud-gcp": {
      "2.0.4": "Spring Boot >=2.4.0-M1 and <2.6.0-M1"
    },
    "spring-cloud-services": {
      "2.3.0.RELEASE": "Spring Boot >=2.3.0.RELEASE and <2.4.0-M1",
      "2.4.1": "Spring Boot >=2.4.0-M1 and <2.5.0-M1"
    },
    "spring-geode": {
      "1.3.12.RELEASE": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
      "1.4.11": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
      "1.5.5": "Spring Boot >=2.5.0-M1 and <2.6.0-M1",
      "1.6.0-M3": "Spring Boot >=2.6.0-M1"
    },
    "vaadin": {
      "14.7.1": "Spring Boot >=2.1.0.RELEASE and <2.6.0-M1"
    },
    "wavefront": {
      "2.0.2": "Spring Boot >=2.1.0.RELEASE and <2.4.0-M1",
      "2.1.1": "Spring Boot >=2.4.0-M1 and <2.5.0-M1",
      "2.2.0": "Spring Boot >=2.5.0-M1"
    }
  },
  "dependency-ranges": {
    "native": {
      "0.9.0": "Spring Boot >=2.4.3 and <2.4.4",
      "0.9.1": "Spring Boot >=2.4.4 and <2.4.5",
      "0.9.2": "Spring Boot >=2.4.5 and <2.5.0-M1",
      "0.10.0": "Spring Boot >=2.5.0-M1 and <2.5.2",
      "0.10.1": "Spring Boot >=2.5.2 and <2.5.3",
      "0.10.2": "Spring Boot >=2.5.3 and <2.5.4",
      "0.10.3": "Spring Boot >=2.5.4 and <2.5.5",
      "0.10.4": "Spring Boot >=2.5.5 and <2.5.6-SNAPSHOT",
      "0.10.5-SNAPSHOT": "Spring Boot >=2.5.6-SNAPSHOT and <2.6.0-M1"
    },
    "okta": {
      "1.4.0": "Spring Boot >=2.2.0.RELEASE and <2.4.0-M1",
      "1.5.1": "Spring Boot >=2.4.0-M1 and <2.4.1",
      "2.0.1": "Spring Boot >=2.4.1 and <2.5.0-M1",
      "2.1.1": "Spring Boot >=2.5.0-M1 and <2.6.0-M1"
    },
    "mybatis": {
      "2.1.4": "Spring Boot >=2.1.0.RELEASE and <2.5.0-M1",
      "2.2.0": "Spring Boot >=2.5.0-M1"
    },
    "camel": {
      "3.5.0": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
      "3.10.0": "Spring Boot >=2.4.0.M1 and <2.5.0-M1",
      "3.11.1": "Spring Boot >=2.5.0.M1 and <2.6.0-M1"
    },
    "open-service-broker": {
      "3.2.0": "Spring Boot >=2.3.0.M1 and <2.4.0-M1",
      "3.3.0": "Spring Boot >=2.4.0-M1 and <2.5.0-M1"
    }
  }
}
```
##微服务停更说明
1,Eureka停用,可以使用zk作为服务注册中心

2,服务调用,Ribbon准备停更,代替为LoadBalance

3,Feign改为OpenFeign

4,Hystrix停更,改为resilence4j

​ 或者阿里巴巴的sentienl

5.Zuul改为gateway

6,服务配置Config改为 Nacos

7,服务总线Bus改为Nacos

![img.png](img.png)
