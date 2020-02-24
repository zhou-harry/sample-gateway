**Gateway 网关代理User服务**
~~~text
 注意：User服务中不能使用：servlet.context-path自定义地址
~~~
###1. 修改接口返回报文
~~~text
 网关路由的接口返回报文格式各异，并且网关也有有一些限流、认证、熔断降级的返回报文，为了统一这些报文的返回格式，网关必须要对接口的返回报文进行修改
 需要注意的是order需要小于-1，需要先于NettyWriteResponseFilter过滤器执行。有了一个这样的过滤器，我们就可以统一返回报文格式了。
~~~

###2. 认证
###3. 限流
~~~~text
 限流必须要有一个key，根据什么来进行限流，ip，接口，或者用户来进行限流，所以我们自定义一个KeyResolver
 最后RedisRateLimiter我们也需要重写，因为不支持多级限流，原生的只会判断一个key。
~~~~
###4. 熔断
~~~text
 当下游接口负载很大，或者接口不通等其他原因导致超时，如果接口不熔断的话将会影响到下游接口得不到喘息，网关也会因为超时连接一直挂起，很可能因为一个子系统的问题导致整个系统的雪崩。所以我们的网关需要设计熔断，当因为熔断器打开时，网关将返回一个降级的应答。
~~~
###5. 动态配置路由和过滤器
~~~text
 上面 routeDefinitionWriter的实现默认是InMemoryRouteDefinitionRepository，将路由存在内存中，我们可以自己实现一个将路由存在redis中的repository。
 this.publisher.publishEvent(new RefreshRoutesEvent(this));则会将CachingRouteLocator中的路由缓存清空。
 以上只是springcloud gateway支持的一小部分功能。
~~~