package elisejoffre.lpdream.iut.fr.my_api_project.ui

import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.create.CreateBeerViewModel
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.detail.DetailBeerViewModel
import elisejoffre.lpdream.iut.fr.my_api_project.ui.beers.list.BeersViewModel
import org.koin.android.ext.koin.androidApplication
import org.koin.androidx.viewmodel.ext.koin.viewModel
import org.koin.dsl.module.module

val viewModule = module {

    viewModel { BeersViewModel(androidApplication()) }

    viewModel { CreateBeerViewModel(androidApplication()) }

    viewModel { DetailBeerViewModel(androidApplication()) }

}