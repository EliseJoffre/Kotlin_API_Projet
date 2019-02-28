package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository

class BeersViewModel(application: Application): AndroidViewModel(application) {

    var beers: LiveData<List<Beer>> = BeerRepository.getAll()

    fun delete(beer: Beer) {
        BeerRepository.delete(beer)
    }
}