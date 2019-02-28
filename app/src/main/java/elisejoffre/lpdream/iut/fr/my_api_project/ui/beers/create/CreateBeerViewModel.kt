package elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create


import android.app.Application
import androidx.lifecycle.AndroidViewModel
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import java.util.*

class CreateBeerViewModel(application: Application): AndroidViewModel(application) {


    var name: String = "Sans titre"

    var tagline: String = "Inconnu"

    var description: String = "Inconnu"

    fun insert() {
        BeerRepository.insert(Beer(name = name, tagline = tagline,description = description))
    }
}