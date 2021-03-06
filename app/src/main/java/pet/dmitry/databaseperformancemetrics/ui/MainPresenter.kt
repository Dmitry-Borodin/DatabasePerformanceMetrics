package pet.dmitry.databaseperformancemetrics.ui

import kotlinx.coroutines.Job
import kotlinx.coroutines.launch
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */

private const val STEP = 50

class MainPresenter : ScopedPresenter<MainView>() {

    private val repository = DependencyGraph.appScope.repository
    var view: MainView? = null
    var activeLoading: Job? = null

    override fun onAttach(view: MainView) {
        super.onAttach(view)
        this.view = view
        launch {
            updateAmounts()
        }
    }

    override fun onDetouch() {
        super.onDetouch()
        this.view = null
    }

    fun onStartStopClicked() {
        if (activeLoading?.isCompleted != false) {
            activeLoading = launch {
                view?.showWorkingState()
                while (true) {
                    repository.addAuthors(STEP, STEP)
                    updateAmounts()
                }
            }
        } else {
            activeLoading?.cancel()
            view?.showPaused()
        }
    }

    private suspend fun updateAmounts() {
        val authorsAndSongs = repository.getAuthorsAndSongsAmount()
        view?.showAuthorsAndSongsAmount(authorsAmount = authorsAndSongs.first, songsAmount = authorsAndSongs.second)
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