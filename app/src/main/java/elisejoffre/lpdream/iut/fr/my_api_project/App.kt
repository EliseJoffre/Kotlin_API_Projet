package elisejoffre.lpdream.iut.fr.my_api_project

import android.app.Application
import org.koin.android.ext.android.startKoin

class  App: Application() {

    override fun onCreate() {
        super.onCreate()

       startKoin(this, appModule)
    }
}