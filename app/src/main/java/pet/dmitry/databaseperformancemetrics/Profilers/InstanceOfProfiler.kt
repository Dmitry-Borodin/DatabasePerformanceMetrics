package pet.dmitry.databaseperformancemetrics.Profilers

/**
 * @author Dmitry Borodin on 2/21/19.
 */
class InstanceOfProfiler {

    val objects: List<Any> = listOf("string", 1, 5L, "ggg", 5.0f)

    fun profile(): ProfileResult {
        val zeroNano = System.nanoTime()
        val initialMillis = System.currentTimeMillis()
        val initialNano = System.nanoTime()
        val newObject = objects.filterIsInstance<String>()
        val endMillis = System.currentTimeMillis()
        val endNano = System.nanoTime()
        return ProfileResult(
            endNano - initialNano, endMillis - initialMillis,
            initialNano - zeroNano, newObject
        )
    }
}