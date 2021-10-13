package i.learn.service.impl

import i.learn.entities.Payment
import i.learn.dao.PaymentDao
import i.learn.service.PayService
import org.springframework.stereotype.Service

@Service
class PayServiceImpl(val paymentDao: PaymentDao) : PayService {
    override fun add(payment: Payment): Long {
        return paymentDao.add(payment)
    }

    override fun getPaymentById(id: Long): List<Payment> {
        return paymentDao.getPaymentById(id)
    }
}
