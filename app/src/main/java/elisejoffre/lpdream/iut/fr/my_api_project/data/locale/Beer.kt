package elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "beer")
data class Beer(

        @PrimaryKey
        var id: Int = 0,

        var name: String = "Nom",

        var tagline: String = "Tagline ",

        var description: String = "Description ",

        var image_url:String? = null,

        var food_pairing: Array<String> = emptyArray(),

        var ingredients: Array<Objects> = emptyArray()





)