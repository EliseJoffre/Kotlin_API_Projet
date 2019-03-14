package elisejoffre.lpdream.iut.fr.my_api_project.data.remote

import com.google.gson.annotations.SerializedName

data class BeerResponse(

        @SerializedName("id")
        val id: Int,

        @SerializedName("name")
        val name: String,

        @SerializedName("tagline")
        val tagline: String,

        @SerializedName("description")
        val description: String,

        @SerializedName("image_url")
        val image_url: String










)