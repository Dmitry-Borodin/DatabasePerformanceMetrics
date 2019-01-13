package pet.dmitry.databaseperformancemetrics.ui

import kotlinx.coroutines.launch
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class MainPresenter : ScopedPresenter<MainView>() {

    private val repository = DependencyGraph.appScope.repository
    var view: MainView? = null

    override fun onAttach(view: MainView) {
        super.onAttach(view)
        this.view = view
    }

    override fun onDetouch() {
        super.onDetouch()
        this.view = null
    }

    fun onStartStopClicked() {
        TODO()
    }

    fun onRefetchMetricsClicked() {
        TODO()
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