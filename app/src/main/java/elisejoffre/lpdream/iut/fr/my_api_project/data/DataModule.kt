package elisejoffre.lpdream.iut.fr.my_api_project.data

import androidx.room.Room
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerDatabase
import elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale.BeerRepository
import org.koin.android.ext.koin.androidApplication
import org.koin.dsl.module.module

val dataModule = module {

    single { Room.databaseBuilder(androidApplication(), BeerDatabase::class.java, BeerDatabase.DATABASE_NAME).build() }

    single { get<BeerDatabase>().beerDao() }

    single { BeerRepository() }

}