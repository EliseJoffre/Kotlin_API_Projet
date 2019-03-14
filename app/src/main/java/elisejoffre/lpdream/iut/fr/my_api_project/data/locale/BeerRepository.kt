package elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import elisejoffre.lpdream.iut.fr.my_api_project.data.remote.BeerResponse
import elisejoffre.lpdream.iut.fr.my_api_project.data.remote.BeerService
import elisejoffre.lpdream.iut.fr.my_api_project.data.remote.BeersResponseCallback
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.rxkotlin.subscribeBy
import io.reactivex.schedulers.Schedulers
import org.jetbrains.anko.doAsync

object BeerRepository {

    private lateinit var database: BeerDatabase

    private lateinit var beerDao: BeerDao

    private val service = BeerService.create()

    fun initialize(application: Application) {
        database = BeerDatabase.buildInstance(application)
        beerDao = database.beerDao()
    }

    //region locale

    fun insertAll(beers: List<Beer>) = doAsync{
        beerDao.insertAll(beers)
        Log.d("beerRepository","inserting movies: $beers")
    }

    fun insert(beer: Beer) = insertAll(listOf(beer))

    fun delete(beer: Beer)= doAsync  { beerDao.delete(beer) }

    fun getById(id: Int): LiveData<Beer> = beerDao.getById(id)

    fun getAll(): LiveData<List<Beer>> = beerDao.getAllLive()

    //endregion

    //region remote

    fun downloadBeers (callback: BeersResponseCallback) {
        service.getBeers()
                .subscribeOn(Schedulers.io())
                .observeOn(AndroidSchedulers.mainThread())
                .subscribeBy(
                        onNext = { beersListResponse -> insertAll(beersListResponse.map { beerResponse -> beerResponseToBeer(beerResponse) }) },
                        onComplete = { callback.onSuccess() },
                        onError = { callback.onError(it) }
                )
    }

    private fun beerResponseToBeer(beerResponse: BeerResponse): Beer = Beer(
            id = beerResponse.id,
            name = beerResponse.name,
            tagline = beerResponse.tagline,
            description = beerResponse.description,
            image_url = beerResponse.image_url

    )

    //endregion

}