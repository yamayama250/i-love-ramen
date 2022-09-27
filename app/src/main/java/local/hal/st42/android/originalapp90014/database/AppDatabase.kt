package local.hal.st42.android.originalapp90014.database

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import local.hal.st42.android.originalapp90014.features.ramen.model.Ramen

@Database(entities = [Ramen::class], version = 1, exportSchema = false)
@TypeConverters(DateTimeConverter::class)
abstract class AppDatabase: RoomDatabase() {
    abstract fun ramenDAO(): RamenDAO

    companion object {
        @Volatile
        private var INSTANCE: AppDatabase? = null
        fun getInstance(context: Context): AppDatabase {
            synchronized(this) {
                var instance = INSTANCE
                if(instance == null) {
                    instance = Room.databaseBuilder(
                        context.applicationContext,
                        AppDatabase::class.java,
                        "ramens"
                    ).build()
                }
                return instance
            }
        }
    }
}