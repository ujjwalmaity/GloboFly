package dev.ujjwal.globofly.services

import dev.ujjwal.globofly.models.Destination
import retrofit2.Call
import retrofit2.http.*

interface DestinationService {

    // http://192.168.43.222:9000/destination
    // http://192.168.43.222:9000/destination?country=India&count=1
    // x-device-type: A7010a48
    // Accept-Language: en
    //@Headers("x-device-type: Android", "x-foo: bar")
    @GET("destination")
    //fun getDestinationList(): Call<List<Destination>>
    //fun getDestinationList(@Query("country") country: String?): Call<List<Destination>>
    //fun getDestinationList(@Query("country") country: String?, @Query("count") count: Int?): Call<List<Destination>>
    fun getDestinationList(@QueryMap filter: HashMap<String, String>): Call<List<Destination>>
    //fun getDestinationList(@QueryMap filter: HashMap<String, String>, @Header("Accept-Language") language: String): Call<List<Destination>>

    // http://192.168.43.222:9000/destination/47
    @GET("destination/{id}")
    fun getDestination(@Path("id") id: Int): Call<Destination>

    // http://192.168.43.222:9000/destination
    // Content-Type: application/json; charset=UTF-8
    // {"city":"New city","country":"New country","description":"Some new description","id":0}
    @POST("destination")
    fun addDestination(@Body newDestination: Destination): Call<Destination>

    // http://192.168.43.222:9000/destination/4
    // Content-Type: application/x-www-form-urlencoded
    // city=Old%20Delhi&description=Nice%20city&country=India
    @FormUrlEncoded
    @PUT("destination/{id}")
    fun updateDestination(
        @Path("id") id: Int,
        @Field("city") city: String,
        @Field("description") desc: String,
        @Field("country") country: String
    ): Call<Destination>

    // http://192.168.43.222:9000/destination/6
    @DELETE("destination/{id}")
    fun deleteDestination(@Path("id") id: Int): Call<Unit>
}