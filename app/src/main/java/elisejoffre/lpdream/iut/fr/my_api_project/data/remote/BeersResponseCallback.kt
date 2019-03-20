package elisejoffre.lpdream.iut.fr.my_api_project.data.remote

interface BeersResponseCallback {

    fun onSuccess()

    fun onError(throwable: Throwable)
}