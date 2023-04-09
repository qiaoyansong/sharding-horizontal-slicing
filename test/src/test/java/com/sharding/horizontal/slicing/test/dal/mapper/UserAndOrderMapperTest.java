package com.sharding.horizontal.slicing.test.dal.mapper;

import com.sharding.horizontal.slicing.dal.domain.Order;
import com.sharding.horizontal.slicing.dal.domain.User;
import com.sharding.horizontal.slicing.dal.mapper.OrderMapper;
import com.sharding.horizontal.slicing.dal.mapper.UserMapper;
import com.sharding.horizontal.slicing.test.BaseTestApplication;
import org.junit.Test;

import javax.annotation.Resource;
import java.math.BigDecimal;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2023/4/8 4:22 下午
 * description：
 */
public class UserAndOrderMapperTest extends BaseTestApplication {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OrderMapper orderMapper;

    @Test
    public void insertSelective_Test_Simple() {
        User user = new User();
        user.setUname("强哥");
        userMapper.insertSelective(user);

        Order order = new Order();
        order.setOrderNo("ATGUIGU001");
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));

        orderMapper.insertSelective(order);
    }

    @Test
    public void transaction_Test_Simple() {
        System.out.println(userMapper.selectByPrimaryKey(1L));
        System.out.println(orderMapper.selectByPrimaryKey(1L));
    }

}
