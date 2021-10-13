package i.learn
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.client.discovery.EnableDiscoveryClient
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableDiscoveryClient
@EnableEurekaClient
@SpringBootApplication
class PayApplication

fun main(args: Array<String>) {
    runApplication<PayApplication>(*args)
}
