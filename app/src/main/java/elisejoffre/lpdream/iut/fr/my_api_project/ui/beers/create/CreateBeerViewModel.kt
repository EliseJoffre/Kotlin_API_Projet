package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerRepository

class CreateBeerViewModel(application: Application): AndroidViewModel(application) {


    var name: MutableLiveData<String> = MutableLiveData()

    var tagline: MutableLiveData<String> = MutableLiveData()

    var description: MutableLiveData<String> = MutableLiveData()

    var imageurl: MutableLiveData<String> = MutableLiveData()

    fun insert() {
        BeerRepository.insert(Beer(name = name.value ?: "", tagline = tagline.value ?: "", description = description.value ?: "", image_url = imageurl.value ?: ""))
    }
}