package com.taozhi.consumer.feign;

import com.taozhi.consumer.feign.fallback.HelloRemoteImpl;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@FeignClient(name= "client-0", fallback = HelloRemoteImpl.class)
public interface IHelloRemote {
    @RequestMapping(value = "/hello")
    public String hello(@RequestParam String name);
}
