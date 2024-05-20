package kr.tekit.lion.daongil.dto.response.areabased


import com.squareup.moshi.JsonClass
import kr.tekit.lion.daongil.dto.base.Header

@JsonClass(generateAdapter = true)
data class Response(
    val body: Body,
    val header: Header
)