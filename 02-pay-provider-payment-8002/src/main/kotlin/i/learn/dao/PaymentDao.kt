package i.learn.dao

import i.learn.entities.Payment
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface PaymentDao {
    fun add(@Param("payment") payment: Payment): Long
    fun getPaymentById(@Param("id") id: Long): List<Payment>
}
