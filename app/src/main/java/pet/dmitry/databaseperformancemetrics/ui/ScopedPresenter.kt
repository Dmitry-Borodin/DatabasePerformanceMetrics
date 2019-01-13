package pet.dmitry.databaseperformancemetrics.ui

import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext

/**
 * @author Dmitry Borodin on 1/13/19.
 */
abstract class ScopedPresenter<T> : CoroutineScope {

    protected lateinit var job: Job
    override val coroutineContext: CoroutineContext
        get() = job + Dispatchers.Main

    open fun onAttach(view: T) {
        job = Job()
    }

    open fun onDetouch() {
        job.cancel()
    }
}