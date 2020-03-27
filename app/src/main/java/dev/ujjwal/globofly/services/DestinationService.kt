package dev.ujjwal.globofly.services

import dev.ujjwal.globofly.models.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

interface DestinationService {

    // http://192.168.43.222:9000/destination
    // http://192.168.43.222:9000/destination?country=India
    @GET("destination")
    fun getDestinationList(@Query("country") country: String?): Call<List<Destination>>

    // http://192.168.43.222:9000/destination/47
    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>
}