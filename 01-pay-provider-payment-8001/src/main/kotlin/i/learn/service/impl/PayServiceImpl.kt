package i.learn.service.impl

import com.netflix.hystrix.contrib.javanica.annotation.DefaultProperties
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty
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

    // 服务熔断
// package com.netflix.hystrix.HystrixCommandProperties; 全部配置
    @HystrixCommand(
        fallbackMethod = "payFailBack",
        commandProperties = [
            HystrixProperty(name = "circuitBreaker.enabled", value = "true"),
            HystrixProperty(name = "circuitBreaker.requestVolumeThreshold", value = "10"), // 请求次数
            HystrixProperty(name = "circuitBreaker.sleepWindowInMilliseconds", value = "10000"), // 时间窗口期
            HystrixProperty(name = "circuitBreaker.errorThresholdPercentage", value = "60"), // 失败率后跳闸
        ]
    )
    override fun pay(money: Long): String {
        if (money < 0) {
            throw RuntimeException("data too low.")
        }
        return "支付成功！"
    }

    fun payFailBack(money: Long): String {
        return "熔断"
    }
}
