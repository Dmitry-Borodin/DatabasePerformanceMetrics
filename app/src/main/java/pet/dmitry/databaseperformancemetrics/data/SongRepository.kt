package pet.dmitry.databaseperformancemetrics.data

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.async
import kotlinx.coroutines.withContext
import java.util.*

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class SongRepository(
    database: Database,
    private val generator: DataGenerator
) {
    private val dao = database.getSongDao()

    suspend fun addAuthors(authorAmount: Int, songsPerAuthor: Int) = withContext(Dispatchers.IO) {
        //generate
        val authors = generator.generateAuthors(authorAmount)
        val songs = ArrayList<Song>().also {
            for (author in authors) it.addAll(generator.generateSongs(songsPerAuthor, authorId = author.id))
        }

        //put to the db
        dao.insertSongs(songs)
        dao.insertAuthors(authors)
    }

    suspend fun getAuthorsAndSongsAmount() : Pair<Long, Long> = withContext(Dispatchers.IO){
        val authorsAmount = async { dao.getAmountOfAuthorsInDb() }
        val songsAmount = async { dao.getAmountOfSongsInDb() }
        return@withContext Pair(authorsAmount.await(), songsAmount.await())
    }
}