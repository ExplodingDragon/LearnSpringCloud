package i.learn.service

interface PayService {
    fun getOk(): String
    fun getTimeOut(long: Long): String
    fun getError(): String
}
