package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerRepository
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.remote.BeersResponseCallback
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class BeersViewModel(application: Application): AndroidViewModel(application), KoinComponent {

    private val beerRepository: BeerRepository by inject()

    var beers: LiveData<List<Beer>> = beerRepository.getAll()

    fun delete(beer: Beer) {
        beerRepository.delete(beer)
    }

    fun refresh(callback: BeersResponseCallback) {
        beerRepository.downloadBeers(callback)
    }
}