package pet.dmitry.databaseperformancemetrics.Profilers

/**
 * @author Dmitry Borodin on 2/21/19.
 */
object InstanceOfProfiler {

    var objects: List<Any>

    init {
        objects = listOf("string", 1, 5L, "ggg", 5.0f)
    }

    fun profile(): ProfileResult {
        val newPlaceholderObject = ArrayList<String>()
        val zeroNano = System.nanoTime()
        val initialMillis = System.currentTimeMillis()
        val initialNano = System.nanoTime()
        val newObject = objects.filterIsInstanceTo(newPlaceholderObject, String::class.java)
        val endMillis = System.currentTimeMillis()
        val endNano = System.nanoTime()
        return ProfileResult(
            endNano - initialNano, endMillis - initialMillis,
            initialNano - zeroNano, newObject
        )
    }
}