package dev.janssenbatista.enfburnout.services

import dev.janssenbatista.enfburnout.models.ApiRequest
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.Header
import retrofit2.http.POST

interface ApiService {

    @POST("api/answers")
    suspend fun sendAnswers(
        @Header("apiKey") apiKey: String,
        @Body answers: ApiRequest
    ): Response<IntArray>
}