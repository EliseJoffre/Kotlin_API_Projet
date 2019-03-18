package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.detail

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.Transformations
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerRepository

class DetailBeerViewModel(application: Application): AndroidViewModel(application) {

    var beerId: MutableLiveData<Int> = MutableLiveData()

    var beer: LiveData<Beer> = Transformations.switchMap(beerId) { id -> BeerRepository.getById(id)
    }




}