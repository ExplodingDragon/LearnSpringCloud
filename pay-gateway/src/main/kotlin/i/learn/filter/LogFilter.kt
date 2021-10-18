package i.learn.filter

import org.springframework.cloud.gateway.filter.GatewayFilterChain
import org.springframework.cloud.gateway.filter.GlobalFilter
import org.springframework.core.Ordered
import org.springframework.stereotype.Component
import org.springframework.web.server.ServerWebExchange
import reactor.core.publisher.Mono

@Component
class LogFilter : GlobalFilter, Ordered {
    override fun filter(exchange: ServerWebExchange, chain: GatewayFilterChain): Mono<Void> {
        println(exchange.request.path)
        if (exchange.request.path.equals("/fail")) {
            return exchange.response.setComplete()
        }
        return chain.filter(exchange)
    }

    override fun getOrder() = 0
}
