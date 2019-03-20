package elisejoffre.lpdream.iut.fr.my_api_project.data.remote

import com.jakewharton.retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory
import io.reactivex.Observable
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface BeerService {

    @GET("beers")
    fun getBeers(
    ): Observable<List<BeerResponse>>

    companion object {

        fun create(): BeerService {


            val client = OkHttpClient.Builder().addInterceptor { chain ->
                val request = chain.request()
                val newUrl = request.url().newBuilder().build()
                chain.proceed(request.newBuilder().url(newUrl).build())
            }.build()

            val retrofit = Retrofit.Builder()
                    .baseUrl("https://api.punkapi.com/v2/")
                    .client(client)
                    .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()

            return retrofit.create(BeerService::class.java)
        }
    }
}