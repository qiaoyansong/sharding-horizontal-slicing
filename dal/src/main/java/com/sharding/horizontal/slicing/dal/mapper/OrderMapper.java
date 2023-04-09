package com.sharding.horizontal.slicing.dal.mapper;

import com.sharding.horizontal.slicing.dal.condition.SelectOrderCondition;
import com.sharding.horizontal.slicing.dal.domain.Order;

import java.util.List;

public interface OrderMapper {
    int deleteByPrimaryKey(Long id);

    int insert(Order record);

    int insertSelective(Order record);

    Order selectByPrimaryKey(Long id);

    /**
     * 根据条件查询订单信息
     *
     * @param condition
     * @return
     */
    List<Order> selectByCondition(SelectOrderCondition condition);

    int updateByPrimaryKeySelective(Order record);

    int updateByPrimaryKey(Order record);
}