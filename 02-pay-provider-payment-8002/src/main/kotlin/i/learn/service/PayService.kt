package i.learn.service

import i.learn.entities.Payment

interface PayService {
    fun add(payment: Payment): Long
    fun getPaymentById(id: Long): List<Payment>
}
