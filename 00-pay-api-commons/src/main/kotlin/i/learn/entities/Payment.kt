package i.learn.entities

import java.io.Serializable

data class Payment(
    val id: Long = -1,
    val serial: String = ""
) : Serializable
