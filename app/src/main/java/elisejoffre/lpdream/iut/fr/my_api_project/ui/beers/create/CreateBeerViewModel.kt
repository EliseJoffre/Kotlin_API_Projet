package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.beers.create


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerRepository
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.Beer
import org.koin.standalone.KoinComponent
import org.koin.standalone.inject

class CreateBeerViewModel(application: Application): AndroidViewModel(application) , KoinComponent {

    private val beerRepository: BeerRepository by inject()
    var name: MutableLiveData<String> = MutableLiveData()

    var tagline: MutableLiveData<String> = MutableLiveData()

    var description: MutableLiveData<String> = MutableLiveData()

    var food_pairing: MutableLiveData<String> = MutableLiveData()

    var brewers_tips: MutableLiveData<String> = MutableLiveData()

    var abv: MutableLiveData<String> = MutableLiveData()

    fun insert() {
        beerRepository.insert(Beer(name = name.value ?: "", tagline = tagline.value ?: "", description = description.value ?: "", image_url = "https://images.punkapi.com/images/v2/71.png" , food_pairing = food_pairing.value ?: "", brewers_tips = brewers_tips.value ?: "", abv = abv.value ?: ""))
    }


}