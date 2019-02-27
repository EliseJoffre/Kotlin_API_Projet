package elisejoffre.lpdream.iut.fr.my_api_project

import android.app.Application
import elisejoffre.lpdream.iut.fr.my_api_project.data.Beer
import elisejoffre.lpdream.iut.fr.my_api_project.data.BeerRepository
import org.jetbrains.anko.doAsync
import java.util.*

class App: Application() {

    override fun onCreate() {
        super.onCreate()

        BeerRepository.initialize(this)

        val calendar = Calendar.getInstance()

        val beers = listOf(
                Beer(id = 1, name = "Paix Dieu", tagline = "lalalal", description = "lalalaal"),
                Beer(id = 2, name = "Heineken", tagline = "lalalal", description = "lalalaal"),
                Beer(id = 3, name = "Desperados", tagline = "lalalal", description = "lalalaal")

                )

         BeerRepository.insertAll(beers)

    }
}