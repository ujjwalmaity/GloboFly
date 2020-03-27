package dev.ujjwal.globofly.services

import dev.ujjwal.globofly.models.Destination
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Path

interface DestinationService {

    // http://192.168.43.222:9000/destination
    @GET("destination")
    fun getDestinationList(): Call<List<Destination>>

    // http://192.168.43.222:9000/destination/47
    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>
}