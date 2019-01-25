package com.taozhi.client2.feign.fallback;

import com.taozhi.client2.feign.IHelloRemote;
import org.springframework.stereotype.Service;

/**
 * 处理熔断返回值
 */
@Service
public class HelloRemoteImpl implements IHelloRemote {

    @Override
    public String hello(String name) {
        return "发生熔断了"; //熔断返回false
    }
}
