package i.learn.controller

import i.learn.entities.CommentResult
import i.learn.entities.Payment
import i.learn.service.PayService
import org.springframework.cloud.client.discovery.DiscoveryClient
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/")
class PayController(
    private val payService: PayService,
    private val discoveryClient: DiscoveryClient
) {
    @PostMapping("/")
    fun create(@RequestBody payment: Payment): CommentResult<Boolean> {
        val res = payService.add(payment)
        return CommentResult(res.toInt(), "", false)
    }

    @GetMapping("{id}")
    fun get(@PathVariable id: Long): CommentResult<List<Payment>> {
        return CommentResult(0, "", payService.getPaymentById(id))
    }

    @GetMapping("/info")
    fun getInfo() = discoveryClient.services

    @GetMapping("/info/{id}")
    fun getInfo(id: String) = discoveryClient.getInstances(id)
}
