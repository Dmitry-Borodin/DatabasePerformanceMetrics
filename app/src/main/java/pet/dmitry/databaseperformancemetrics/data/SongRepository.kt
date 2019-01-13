package pet.dmitry.databaseperformancemetrics.data

import java.util.*

/**
 * @author Dmitry Borodin on 1/13/19.
 */
class SongRepository(
    database: Database,
    private val generator: DataGenerator
) {
    private val dao = database.getSongDao()

    fun addAuthors(authorAmount: Int, songsPerAuthor: Int) {
        //generate
        val authors = generator.generateAuthors(authorAmount)
        val songs = ArrayList<Song>().also {
            for (author in authors) it.addAll(generator.generateSongs(songsPerAuthor, authorId = author.id))
        }

        //put to the db
        dao.insertSongs(songs)
        dao.insertAuthors(authors)
    }
}