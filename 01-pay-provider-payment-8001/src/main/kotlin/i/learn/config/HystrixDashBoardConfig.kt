package i.learn.config

import com.netflix.hystrix.contrib.metrics.eventstream.HystrixMetricsStreamServlet
import org.springframework.boot.web.servlet.ServletRegistrationBean
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class HystrixDashBoardConfig {
    @Bean
    fun getServlet() = ServletRegistrationBean(HystrixMetricsStreamServlet()).apply {
        setLoadOnStartup(1)
        addUrlMappings("/hystrix.stream")
        setName("HystrixMetricsStreamServlet")
    }
}
