package dev.ujjwal.globofly.services

import dev.ujjwal.globofly.models.Destination
import retrofit2.Call
import retrofit2.http.*

interface DestinationService {

    // http://192.168.43.222:9000/destination
    // http://192.168.43.222:9000/destination?country=India&count=1
    @GET("destination")
    //fun getDestinationList(): Call<List<Destination>>
    //fun getDestinationList(@Query("country") country: String?): Call<List<Destination>>
    //fun getDestinationList(@Query("country") country: String?, @Query("count") count: Int?): Call<List<Destination>>
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>

    // http://192.168.43.222:9000/destination/47
    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    @POST("destination")
    fun addDestination(@Body newDestination: Destination): Call<Destination>
}