package com.mashibing.seatastock8802.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface StockMapper {

    @Insert("update stock set count=count-1 where id=1")
    void decrement();

}
