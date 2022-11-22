package com.mashibing.cloudalibabasentinelservice8401.handler;

import com.alibaba.csp.sentinel.slots.block.BlockException;

public class CustomerBlockHandler {
    public static String handlerException1(BlockException e) {
        return "1111111111";
    }

    public static String handlerException2(BlockException e) {
        return "222222222";
    }
}
