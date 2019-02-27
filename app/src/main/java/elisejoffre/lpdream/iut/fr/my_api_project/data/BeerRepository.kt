package elisejoffre.lpdream.iut.fr.my_api_project.data

import android.app.Application
import android.util.Log
import androidx.lifecycle.LiveData
import org.jetbrains.anko.doAsync

object BeerRepository {

    private lateinit var database: BeerDatabase

    private lateinit var beerDao: BeerDao

    fun initialize(application: Application) {
        database = BeerDatabase.buildInstance(application)
        beerDao = database.beerDao()
    }

    fun insertAll(beers: List<Beer>) = doAsync{
        beers.forEach { beer -> if(beer.id == 0) beer.id = (beerDao.getAll().maxBy { it.id }?.id ?: 0) + 1 }
        beerDao.insertAll(beers)
        Log.d("beerRepository","inserting beers: $beers")
    }

    fun insert(beer: Beer) = insertAll(listOf(beer))

    fun delete(beer: Beer)= doAsync  {
        beerDao.delete(beer)
    }

    fun getById(id: Int): LiveData<Beer> = beerDao.getById(id)


    fun getAll(): LiveData<List<Beer>> = beerDao.getAllLive()
}