package i.learn.config

import org.springframework.cloud.gateway.route.RouteLocator
import org.springframework.cloud.gateway.route.builder.RouteLocatorBuilder
import org.springframework.context.annotation.Bean
import org.springframework.stereotype.Component

@Component
class GatewayConfig {
    @Bean
    fun route(routes: RouteLocatorBuilder): RouteLocator = kotlin.run {
        routes.routes().apply {
            route("name") {
                it.path("/guonei").uri("http://news.baidu.com/guonei")
            }
        }.build()
    }
}
