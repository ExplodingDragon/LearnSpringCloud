package i.learn.controller

import i.learn.entities.CommentResult
import i.learn.entities.Payment
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate

@RestController
class OrderController(private val restTemplate: RestTemplate) {
    private val url = "http://127.0.0.1:8001"

    @PostMapping("/")
    fun createPayment(@RequestBody payment: Payment) =
        restTemplate.postForObject("$url/", payment, CommentResult::class.java)

    @Suppress("UNCHECKED_CAST")
    @GetMapping("{id}")
    fun get(@PathVariable id: Long): CommentResult<List<Payment>> {
        return restTemplate.getForObject("$url/$id", CommentResult::class.java) as CommentResult<List<Payment>>
    }
}
