package pet.dmitry.databaseperformancemetrics

import android.app.Application
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class App() : Application() {

    override fun onCreate() {
        DependencyGraph.appScope = DependencyGraph.AppScope(this)
        super.onCreate()
    }
}