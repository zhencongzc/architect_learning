package com.mashibing.seataorder8801.mapper;

import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

@Mapper
public interface OrderMapper {

    @Insert("insert into table_order values(null, 1)")
    void createOrder();

}
