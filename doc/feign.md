#### Feign使用Demo

M：怎么使用Feign进行接口调用呢？

Z：SpringCloud对Feign进行了封装，当我们搭建好注册中心Eureka之后，将服务注册到Eureka上，就可以通过Feign进行调用。

Z：提供者像往常Controller的写法一样

```java
    /**
     * 获取语料库关键字
     * @return Map
     */
    @RequestMapping(value = "/findAllList",method = {RequestMethod.POST,RequestMethod.GET})
    public List<Corpus> findAllList() {
        List<Corpus> resultList = ConverterUtil.convertList(EdaCorpus.class, Corpus.class, edaCorpusService.list());
        return resultList;
    }
```

而消费者的接口需要注意，与提供者的返回类型相同（支持返回复杂类型）。如果带参数，务必在提供方和消费方都添加``@RequestParam("info")``注明参数对象。

```java
@FeignClient(name = "eda-unify-base-service", fallback = CorpusServiceFallbackImpl.class)
public interface CorpusService {
    @PostMapping("/corpus/findAllList")
    List<Corpus> findAllList();
}
```

FeignClient指明调用的服务对象和熔断时返回的内容，熔断时返回空的信息

```java
@Service
public class CorpusServiceFallbackImpl implements CorpusService {

    @Override
    public List<Corpus> findAllList() {
        return new ArrayList<Corpus>();
    }

}
```

Z：完成了信息的接收之后，相当于在当前服务构建了一个Service，通过注入的方式就可以使用该Service的方法