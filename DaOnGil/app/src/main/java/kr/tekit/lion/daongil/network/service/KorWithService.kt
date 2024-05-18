package kr.tekit.lion.daongil.network.service

import kr.tekit.lion.daongil.dto.response.areacode.AreaCodeResponse
import retrofit2.http.GET
import retrofit2.http.QueryMap

interface KorWithService {
    @GET("areaCode1")
    suspend fun getAreaCode(
        @QueryMap params: Map<String, String>
    ): AreaCodeResponse
}