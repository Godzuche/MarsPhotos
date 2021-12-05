package com.example.android.marsphotos.network

import retrofit2.Retrofit
import retrofit2.converter.scalars.ScalarsConverterFactory
import retrofit2.http.GET

// The base url
private const val BASE_URL = "https://android-kotlin-fun-mars-server.appspot.com"

// Retrofit  builder to create a Retrofit object
private val retrofit = Retrofit.Builder()
    // The scalar converter supports strings and other primitive types...it helps retrofit convert the JSON response
    // from the web service to a string in this use case
    .addConverterFactory(ScalarsConverterFactory.create())
    .baseUrl(BASE_URL)
    .build()

// An interface that defines how Retrofit talks to the web server using HTTP requests
interface MarsApiService {
    // .., a function to get the response string from the web service
    // use the @GET annotation to tell Retrofit that this is a GET request and specify endpoint - "/photos"
    @GET("photos")
    fun getPhotos(): String
}

// Expose the service to the rest of the app using singleton - "object" cause the call to create() function on a Retrofit object is
// expensive so the app needs only one instance
object MarsApi {
    // initialize the Retrofit service
    // lazy initialization to make sure it is  initialized at its first usage
    val retrofitService: MarsApiService by lazy {
        // initialize the retrofitService variable with the MarsApiService interface
        retrofit.create(MarsApiService::class.java)
    }
}