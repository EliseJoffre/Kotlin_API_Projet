package elisejoffre.lpdream.iut.fr.my_api_project.data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "beer")
data class Beer(

        @PrimaryKey
        override var id: Int = 0,

        var name: String = "Nom",

        var tagline: String = "Tagline ",

        var description: String = "Description ",

        var image_url:String? = "",

        var food_pairing: String = "",

        var brewers_tips: String = "",

        var abv: String = "",

        var first_brewed: String = ""


): BaseObject