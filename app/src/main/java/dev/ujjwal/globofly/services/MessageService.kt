package dev.ujjwal.globofly.services

import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Url

interface MessageService {

    // http://192.168.43.222:8000/messages
    @GET()
    fun getMessages(@Url anotherUrl: String): Call<String>
}