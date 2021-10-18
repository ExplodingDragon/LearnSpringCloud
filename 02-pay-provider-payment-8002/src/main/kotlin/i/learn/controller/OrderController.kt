package i.learn.controller

import i.learn.service.PayFeignService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RestController

@RestController
class OrderController(
    private val payFeignService: PayFeignService
) {

    @GetMapping("ok")
    fun getOk() = payFeignService.getOk()

    @GetMapping("sleep/{time}")
    fun getTimeOut(@PathVariable time: Long) = payFeignService.getTimeOut(time)

    @GetMapping("error")
    fun getError() = payFeignService.getError()
}
