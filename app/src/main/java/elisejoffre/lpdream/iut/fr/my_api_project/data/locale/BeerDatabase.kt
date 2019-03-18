package elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import elisejoffre.lpdream.iut.fr.my_api_project.data.model.Beer

@Database(entities = [Beer::class], version = 21, exportSchema = false)
abstract class BeerDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao

    companion object {

        const val DATABASE_NAME = "BeerDatabase"
    }
}