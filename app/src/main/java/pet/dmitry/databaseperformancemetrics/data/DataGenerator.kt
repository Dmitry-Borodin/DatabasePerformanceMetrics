package pet.dmitry.databaseperformancemetrics.data

import java.util.concurrent.atomic.AtomicLong

/**
 * @author Dmitry Borodin on 1/13/19.
 */
object DataGenerator {

    val songIdCounter = AtomicLong(1)
    val authorIdCounter = AtomicLong(1)

    fun generateSongs(amount: Int, authorId: Long): List<Song> {
        return List(amount) {
            Song(id = songIdCounter.incrementAndGet(), authorId = authorId, name = "some dummy song name", url = "http://duckduckgo.com")
        }
    }
}