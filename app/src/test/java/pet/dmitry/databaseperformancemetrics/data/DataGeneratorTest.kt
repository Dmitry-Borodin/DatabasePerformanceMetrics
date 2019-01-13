package pet.dmitry.databaseperformancemetrics.data

import org.junit.Assert.*
import org.junit.Test

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class DataGeneratorTest {

    val dataGenerator = DataGenerator

    @Test
    fun shouldGenerateSongs() {
        val songs = dataGenerator.generateSongs(amount = 10, authorId = 36)

        assertEquals(10, songs.size)
        for (song in songs) {
            assertEquals(36, song.authorId)
        }
    }
}