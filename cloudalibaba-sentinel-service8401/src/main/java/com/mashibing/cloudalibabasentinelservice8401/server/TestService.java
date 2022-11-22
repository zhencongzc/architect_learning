package com.mashibing.cloudalibabasentinelservice8401.server;

import com.alibaba.csp.sentinel.annotation.SentinelResource;
import org.springframework.stereotype.Service;



@Service
public class TestService {

    @SentinelResource
    public String common() {
        return "common";
    }

}
