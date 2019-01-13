package pet.dmitry.databaseperformancemetrics.data

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query

/**
 * @author Dmitry Borodin on 1/13/19.
 */
@Dao
interface SongsDao {

    @Insert
    fun insertAuthors(authors: List<Author>)

    @Insert
    fun insersSongs(songs: List<Song>)

    @Query("SELECT * FROM author")
    fun getAllAuthors()

    @Query("SELECT * FROM song WHERE authorId = :authorId")
    fun getSongsOfAuthor(authorId: Long)
}