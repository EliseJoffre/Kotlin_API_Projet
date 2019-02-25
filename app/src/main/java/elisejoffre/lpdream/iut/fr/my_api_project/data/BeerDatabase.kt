package elisejoffre.lpdream.iut.fr.my_api_project.data

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters

@Database(entities = [Beer::class], version = 1, exportSchema = false)
@TypeConverters(DateConverter::class)
abstract class BeerDatabase : RoomDatabase() {

    abstract fun beerDao(): BeerDao

    companion object {

        fun buildInstance(context: Context) = Room
                .databaseBuilder(context, BeerDatabase::class.java, "BeerDatabase")
                .build()
    }
}