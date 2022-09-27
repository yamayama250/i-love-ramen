package local.hal.st42.android.originalapp90014.features.ramen.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.sql.Date

@Entity(tableName = "ramen_shops")
data class Ramen(
    @PrimaryKey(autoGenerate = true)
    val id: Int?,
    val name: String,
    val address: String,
    val visitDate: Date,
    val category: String,
    val note: String,
    val registryDate: Date,
    val updateDate: Date
)