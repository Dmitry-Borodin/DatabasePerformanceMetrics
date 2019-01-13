package pet.dmitry.databaseperformancemetrics

import android.app.Application
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph
import timber.log.Timber

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class App() : Application() {

    override fun onCreate() {
        super.onCreate()
        DependencyGraph.appScope = DependencyGraph.AppScope(this)
        if (BuildConfig.DEBUG) {
            Timber.plant(Timber.DebugTree())
        }
    }
}