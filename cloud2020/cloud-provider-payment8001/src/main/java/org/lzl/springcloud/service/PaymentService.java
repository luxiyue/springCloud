package org.lzl.springcloud.service;

import org.apache.ibatis.annotations.Param;
import org.lzl.springcloud.entities.Payment;
/**
 * @author luzelong
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/3 13:47
 *
 */
public interface PaymentService {
    public int create(Payment payment);
    public Payment getPaymentById(@Param("id") Long id);
}
