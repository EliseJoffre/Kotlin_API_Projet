package elisejoffre.lpdream.iut.fr.my_api_project.data

import androidx.room.*

@Dao
interface BeerDao {

    @Query("SELECT * FROM beer WHERE id = :id")
    fun getById(id: Int): Beer

    @Query("SELECT * FROM Beer ORDER BY name")
    fun getAll(): List<Beer>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insert(movie: Beer)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertAll(list: List<Beer>)

    @Delete
    fun delete(beer: Beer)

}