package com.sharding.horizontal.slicing.test.dal.mapper;

import com.sharding.horizontal.slicing.dal.condition.SelectOrderCondition;
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
        generateOrderLists1();
        generateOrderLists2();
    }

    /**
     * 根据用户ID查询数据
     */
    @Test
    public void selectByCondition_Test_Simple() {
        SelectOrderCondition condition = new SelectOrderCondition();
        condition.setUserId(3L);
        orderMapper.selectByCondition(condition).forEach(System.out::println);
    }

    /**
     * 查询所有数据
     */
    @Test
    public void selectByCondition_Test_FetchAll() {
        orderMapper.selectByCondition(new SelectOrderCondition()).forEach(System.out::println);
    }

    private void generateOrderLists2() {
        User user = new User();
        user.setUname("强哥2号");
        userMapper.insertSelective(user);


        Order order = new Order();
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(200));

        Order order2 = new Order();
        order2.setUserId(user.getId());
        order2.setAmount(new BigDecimal(20));

        orderMapper.insertSelective(order);
        orderMapper.insertSelective(order2);
    }

    private void generateOrderLists1() {
        User user = new User();
        user.setUname("强哥1号");
        userMapper.insertSelective(user);


        Order order = new Order();
        order.setUserId(user.getId());
        order.setAmount(new BigDecimal(100));

        Order order2 = new Order();
        order2.setUserId(user.getId());
        order2.setAmount(new BigDecimal(10));

        orderMapper.insertSelective(order);
        orderMapper.insertSelective(order2);
    }

}
