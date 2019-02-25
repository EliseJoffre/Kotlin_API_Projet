package elisejoffre.lpdream.iut.fr.my_api_project.data

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "beer")
data class Beer(

        @PrimaryKey
        var id: Int = 0,

        var name: String = "Sans titre",

        var tagline: String = "Inconnu",

        var description: String = "Inconnu"


        )