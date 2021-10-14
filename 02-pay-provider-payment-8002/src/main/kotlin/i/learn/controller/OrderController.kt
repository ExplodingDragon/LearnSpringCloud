package i.learn.controller

import i.learn.entities.CommentResult
import i.learn.entities.Payment
import i.learn.service.PayFeignService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class OrderController(
    private val restTemplate: RestTemplate,
    private val payFeignService: PayFeignService
) {
    private val url = "http://PAY-PAYMENT-SERVICE"

    @PostMapping("/")
    fun createPayment(@RequestBody payment: Payment) = kotlin.run {
        val postForEntity = restTemplate.postForEntity("$url/", payment, CommentResult::class.java)
        if (postForEntity.statusCode.is2xxSuccessful) {
            postForEntity.body
        } else {
            CommentResult(400, "", "")
        }
    }

    @Suppress("UNCHECKED_CAST")
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): CommentResult<List<Payment>> {
        return payFeignService.getId(id)
    }
}
