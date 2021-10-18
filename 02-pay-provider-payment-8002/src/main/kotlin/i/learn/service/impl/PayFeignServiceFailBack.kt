package i.learn.service.impl

import i.learn.service.PayFeignService
import org.springframework.stereotype.Component

@Component
class PayFeignServiceFailBack : PayFeignService {
    override fun getOk(): String {
        return "客户端熔断错误"
    }

    override fun getTimeOut(time: Long): String {

        return "客户端熔断错误 ${time}"
    }

    override fun getError(): String {
        return "客户端熔断错误 error"

    }
}
