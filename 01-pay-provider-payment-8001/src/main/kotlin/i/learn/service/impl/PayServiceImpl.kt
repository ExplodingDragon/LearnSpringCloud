package i.learn.service.impl

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import i.learn.service.PayService
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Service

@DefaultProperties(defaultFallback = "globalError")
@Service
class PayServiceImpl : PayService {
    @Value("\${server.port}")
    var port: Long = 0
    override fun getOk(): String {
        return "Get OK! $port"
    }

    @HystrixCommand
    override fun getTimeOut(long: Long): String {
        Thread.sleep(long)
        return "休眠 $long 毫秒"
    }

    @HystrixCommand
    override fun getError(): String {
        throw RuntimeException("系统错误！")
    }

    fun globalError() = "程序错误，已降级"
}
