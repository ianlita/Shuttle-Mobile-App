package com.example.shuttleapp.data.network

import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerResponseBodyDto
import com.example.shuttleapp.data.network.response.RouteDto
import com.example.shuttleapp.data.network.response.ShuttleDto
import com.example.shuttleapp.data.network.response.ShuttlePassWithPassengerDto
import com.example.shuttleapp.data.network.response.ShuttleProviderDto
import retrofit2.Response
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface ShuttleApi {

    @GET("shuttleproviders/")
    suspend fun getAllShuttleProviders() : List<ShuttleProviderDto>

    @GET("routes/")
    suspend fun getRoutes() : List<RouteDto>

    @GET("shuttles/providerid/{id}/")
    suspend fun getShuttlesByProviderId(
        @Path("id") id: String
    ) : List<ShuttleDto>

    @POST("shuttlepasses/")
    suspend fun postShuttlePassWithPassenger(
        @Body
        shuttlePassWithPassenger: List<ShuttlePassWithPassengerDto>

    ) : Response<ShuttlePassWithPassengerResponseBodyDto>

}

/* 1st
1) create base url, and api key(under certain condtion for the api network call inside the
companion object
2) create function to handle network requests(get post put etc)

 */