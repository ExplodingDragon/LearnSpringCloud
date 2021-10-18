package i.learn.controller

import i.learn.service.PayService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PayController(
    private val payService: PayService,

) {

    @GetMapping("ok")
    fun getOk() = payService.getOk()

    @GetMapping("sleep/{time}")
    fun getTimeOut(@PathVariable time: Long) = payService.getTimeOut(time)

    @GetMapping("error")
    fun getError() = payService.getError()

    @GetMapping("pay/{money}")
    fun pay(@PathVariable money: Long) = payService.pay(money)
}
