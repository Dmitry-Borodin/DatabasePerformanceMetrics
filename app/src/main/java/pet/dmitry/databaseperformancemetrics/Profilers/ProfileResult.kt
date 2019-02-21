package pet.dmitry.databaseperformancemetrics.Profilers

/**
 * @author Dmitry Borodin on 2/21/19.
 */
data class ProfileResult(
    val nanoResult: Long,
    val millisResult: Long,
    val measuringOverhead: Long,
    val resultObject: Any
)