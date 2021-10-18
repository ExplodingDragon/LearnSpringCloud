package i.learn

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.hystrix.EnableHystrix

@EnableDiscoveryClient
@SpringBootApplication
@EnableHystrix
class PayApplication

fun main(args: Array<String>) {
    runApplication<PayApplication>(*args)
}
