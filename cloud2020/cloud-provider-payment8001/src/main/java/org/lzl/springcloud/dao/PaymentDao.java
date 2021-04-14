package org.lzl.springcloud.dao;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.lzl.springcloud.entities.Payment;

/**
 *
 * @author luzelong
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/3 13:26
 *
 */
@Mapper
public interface PaymentDao {
    public int create(Payment payment);

    public Payment getPaymentById(@Param("id") Long id);

}
