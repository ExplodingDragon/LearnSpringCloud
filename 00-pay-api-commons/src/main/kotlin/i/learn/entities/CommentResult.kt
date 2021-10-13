package i.learn.entities

data class CommentResult<T : Any>(
    val code: Int = 0,
    val message: String = "",
    val data: T

)
