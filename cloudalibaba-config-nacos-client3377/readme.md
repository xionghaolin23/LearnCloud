nacos配置中心
![img.png](img.png)

nacos功能相当于springcloud config+bus了  因为nacos会自动刷新更改的配置（以前需要bus做）

nacos 还可以作为服务配置中心，下面是案例，创建一个模块，从nacos上读取配置信息。

nacos 作为配置中心，不需要像springcloud config 一样做一个Server端模块。