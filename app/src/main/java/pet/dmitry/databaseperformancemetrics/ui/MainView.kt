package pet.dmitry.databaseperformancemetrics.ui

/**
 * @author Dmitry Borodin on 1/13/19.
 */
interface MainView {

    fun showAuthorsAndSongsAmount(authorsAmount: Long, songsAmount: Long)
    fun showPaused()
    fun showWorkingState()
}