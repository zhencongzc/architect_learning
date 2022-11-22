package com.mashibing.seataorder8801.service.impl;

import com.mashibing.seataorder8801.client.StockClient;
import com.mashibing.seataorder8801.mapper.OrderMapper;
import com.mashibing.seataorder8801.service.OrderService;
import io.seata.spring.annotation.GlobalTransactional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    OrderMapper orderMapper;

    @Autowired
    StockClient stockClient;

    @Override
    @GlobalTransactional
    public void createOrder() {
        stockClient.decrement();


//        System.out.println(1 / 0);

        orderMapper.createOrder();
    }

}
