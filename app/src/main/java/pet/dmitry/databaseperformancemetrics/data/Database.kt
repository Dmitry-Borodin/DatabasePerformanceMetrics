package pet.dmitry.databaseperformancemetrics.data

import androidx.room.Database
import androidx.room.RoomDatabase

/**
 * @author Dmitry Borodin on 1/13/19.
 */

@Database(entities = [(Author::class), (Song::class)], version = 1, exportSchema = false)
abstract class Database : RoomDatabase() {

    abstract fun getSongDao(): SongsDao

}