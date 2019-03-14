package elisejoffre.lpdream.iut.fr.my_api_project.data.locale.locale

import android.util.Log
import androidx.room.*
import androidx.lifecycle.LiveData

@Dao
interface BeerDao {

    @Query("SELECT * FROM beer WHERE id = :id")
    fun getById(id: Int): LiveData<Beer>

    @Query("SELECT * FROM Beer ORDER BY name")
    fun getAll(): List<Beer>

    @Query("SELECT * FROM Beer ORDER BY name")
    fun getAllLive(): LiveData<List<Beer>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Beer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Beer>)

    @Delete
    fun delete(beer: Beer)

}