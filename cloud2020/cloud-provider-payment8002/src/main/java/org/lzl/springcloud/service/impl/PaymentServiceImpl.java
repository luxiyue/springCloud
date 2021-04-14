package org.lzl.springcloud.service.impl;

import org.lzl.springcloud.dao.PaymentDao;
import org.lzl.springcloud.entities.Payment;
import org.lzl.springcloud.service.PaymentService;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 *
 * @author luzelong
 * @creed: Talk is cheap,show me the code
 * @date 2021/2/3 13:51
 *
 */
@Service
public class PaymentServiceImpl implements PaymentService {
    @Resource
    private PaymentDao paymentDao;

    @Override
    public int create(Payment payment) {
        return paymentDao.create(payment);
    }

    @Override
    public Payment getPaymentById(Long id) {
        return paymentDao.getPaymentById(id);
    }
}
