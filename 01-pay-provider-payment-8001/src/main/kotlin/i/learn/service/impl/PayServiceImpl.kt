package i.learn.service.impl

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
import i.learn.service.PayService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@Service
class PayServiceImpl : PayService {
    @Value("\${server.port}")
    var port: Long = 0
    override fun getOk(): String {
        return "Get OK! $port"
    }

    @HystrixCommand(
        fallbackMethod = "getTimeOutFail",
        commandProperties = [
            HystrixProperty(
                name = "execution.isolation.thread.timeoutInMilliseconds",
                value = "3000"
            ) // 超时 3 S
        ]
    )
    override fun getTimeOut(long: Long): String {
        Thread.sleep(long)
        return "休眠 $long 毫秒"
    }

    fun getTimeOutFail(long: Long): String = "超时了"

    @HystrixCommand(
        fallbackMethod = "getErrorFail"
    )
    override fun getError(): String {
        throw RuntimeException("系统错误！")
    }
    fun getErrorFail() = "程序错误，已降级"
}
