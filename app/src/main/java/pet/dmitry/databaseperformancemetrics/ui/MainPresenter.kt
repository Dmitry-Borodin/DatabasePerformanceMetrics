package pet.dmitry.databaseperformancemetrics.ui

import kotlinx.coroutines.launch
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class MainPresenter : ScopedPresenter() {

    private val repository = DependencyGraph.appScope.repository

    fun onStartStopClicked() {

    }

    fun onRefetchMetricsClicked() {

    }

    private fun startSavingData() {
        launch {
            repository.addAuthors(10, 5)
        }
    }

    fun updateAuthorsAndMessagesAmount() {
        launch {
            val authorsAndSongs = repository.getAuthorsAndSongsAmount()
        }
    }
}