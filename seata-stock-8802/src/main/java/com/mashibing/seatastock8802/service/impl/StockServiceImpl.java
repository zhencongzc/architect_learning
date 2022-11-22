package com.mashibing.seatastock8802.service.impl;

import com.mashibing.seatastock8802.mapper.StockMapper;
import com.mashibing.seatastock8802.service.StockService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class StockServiceImpl implements StockService {

    @Autowired
    StockMapper stockMapper;

    @Override
    public void decrement() {
        stockMapper.decrement();
    }
}
