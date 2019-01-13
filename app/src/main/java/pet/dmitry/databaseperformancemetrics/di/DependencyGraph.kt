package pet.dmitry.databaseperformancemetrics.di

import android.annotation.SuppressLint
import android.content.Context
import androidx.room.Room
import pet.dmitry.databaseperformancemetrics.data.DataGenerator
import pet.dmitry.databaseperformancemetrics.data.Database
import pet.dmitry.databaseperformancemetrics.data.SongRepository

/**
 * @author Dmitry Borodin on 1/13/19.
 */

@SuppressLint("StaticFieldLeak")
object DependencyGraph {

    lateinit var appScope: AppScope

    class AppScope(val appContext: Context) {
        val database: Database by lazy {
            Room.databaseBuilder(
                appContext,
                Database::class.java,
                "AppDatabase"
            ).build()
        }

        val generator: DataGenerator = DataGenerator

        val repository by lazy { SongRepository(database, generator) }
    }
}