package pet.dmitry.databaseperformancemetrics.ui

import kotlinx.coroutines.launch
import pet.dmitry.databaseperformancemetrics.data.SongRepository
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class MainPresenter : ScopedPresenter() {

    val repository = DependencyGraph.appScope.repository

    fun startSavingData() {
        launch {
            repository.addAuthors(10,5)
        }
    }

    fun updateAuthorsAndMessagesAmount() {

    }
}