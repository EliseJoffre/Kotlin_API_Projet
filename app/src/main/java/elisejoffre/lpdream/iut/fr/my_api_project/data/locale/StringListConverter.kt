package elisejoffre.lpdream.iut.fr.my_api_project.data.locale

import androidx.room.TypeConverter

class StringListConverter{

    @TypeConverter
    fun fromList(list: List<String>?): String = list?.joinToString("\n") ?: ""

    @TypeConverter
    fun toList(string : String?):List<String> = string?.split(",") ?: listOf()
}