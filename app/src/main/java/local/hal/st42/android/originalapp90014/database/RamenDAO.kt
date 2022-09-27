package local.hal.st42.android.originalapp90014.database

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import androidx.room.Update
import kotlinx.coroutines.flow.Flow
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen

@Dao
interface RamenDAO {
    @Query("SELECT * FROM ramen_shops")
    fun getAll(): Flow<List<Ramen>>

    @Query("SELECT * FROM ramen_shops WHERE id = :id")
    fun findById(id: Int): Flow<Ramen>

    @Insert(onConflict = OnConflictStrategy.IGNORE)
    fun insertRamen(ramens: Ramen)

    @Update
    fun updateRamen(ramens: Ramen)

    @Delete
    fun deleteRamen(ramen: Ramen)
}