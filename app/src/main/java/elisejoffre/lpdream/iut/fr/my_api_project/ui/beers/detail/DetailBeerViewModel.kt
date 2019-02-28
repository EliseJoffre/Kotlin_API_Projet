package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository

class DetailBeerViewModel(application: Application): AndroidViewModel(application) {

    var beerId: MutableLiveData<Int> = MutableLiveData()

    var beer: LiveData<Beer> = Transformations.switchMap(beerId) { id -> BeerRepository.getById(id) }
}