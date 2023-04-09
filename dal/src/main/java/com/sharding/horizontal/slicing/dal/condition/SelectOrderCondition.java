package com.sharding.horizontal.slicing.dal.condition;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * @author ：Qiao Yansong
 * @date ：Created in 2023/4/9 5:31 下午
 * description：
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class SelectOrderCondition {

    /**
     * 用户ID
     */
    private Long userId;

}
