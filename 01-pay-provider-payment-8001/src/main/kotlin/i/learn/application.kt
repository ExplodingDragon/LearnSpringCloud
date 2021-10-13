package i.learn
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.cloud.netflix.eureka.EnableEurekaClient

@EnableEurekaClient
@SpringBootApplication
class PayApplication

fun main(args: Array<String>) {
    runApplication<PayApplication>(*args)
}
