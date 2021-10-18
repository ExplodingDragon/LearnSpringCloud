package i.learn.service

import org.springframework.cloud.openfeign.FeignClient
import org.springframework.stereotype.Component
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable

@Component
@FeignClient(value = "PAY-PAYMENT-SERVICE")
interface PayFeignService {
    @GetMapping("ok")
    fun getOk(): String

    @GetMapping("sleep/{time}")
    fun getTimeOut(@PathVariable time: Long): String

    @GetMapping("error")
    fun getError(): String
}
