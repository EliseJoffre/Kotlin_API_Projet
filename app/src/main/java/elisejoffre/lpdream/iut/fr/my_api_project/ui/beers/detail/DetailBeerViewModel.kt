package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.Beer
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class DetailBeerViewModel(application: Application): AndroidViewModel(application) , KoinComponent {

    private val beerRepository: BeerRepository by inject()

    var beerId: MutableLiveData<Int> = MutableLiveData()

    var beer: LiveData<Beer> = Transformations.switchMap(beerId) { id -> beerRepository.getById(id)
    }

}