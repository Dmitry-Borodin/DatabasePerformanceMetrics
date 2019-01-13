package pet.dmitry.databaseperformancemetrics.di

import android.content.Context
import androidx.room.Room
import pet.dmitry.databaseperformancemetrics.data.DataGenerator
import pet.dmitry.databaseperformancemetrics.data.Database

/**
 * @author Dmitry Borodin on 1/13/19.
 */
object DependencyGraph {
    lateinit var appScope : AppScope

    class AppScope(val appContext: Context) {
        val database: Database by lazy {
            Room.databaseBuilder(
                appContext,
                Database::class.java,
                "AppDatabase"
            ).build()
        }

        val generator: DataGenerator = DataGenerator

        val repository = Unit
    }
}