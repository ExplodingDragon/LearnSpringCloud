package i.learn.service

import i.learn.entities.CommentResult
import i.learn.entities.Payment
import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(value = "PAY-PAYMENT-SERVICE")
interface PayFeignService {
    @GetMapping("/{id}")
    fun getId(@PathVariable("id") id: Long): CommentResult<List<Payment>>
}
