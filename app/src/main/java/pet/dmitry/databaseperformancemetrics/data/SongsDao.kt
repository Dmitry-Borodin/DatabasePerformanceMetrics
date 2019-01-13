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
    fun insertSongs(songs: List<Song>)

    @Query("SELECT * FROM author")
    fun getAllAuthors() : List<Author>

    @Query("SELECT * FROM song WHERE authorId = :authorId")
    fun getSongsOfAuthor(authorId: Long) : List<Song>

    @Query("SELECT Count(*) from song")
    fun getAmountOfSongsInDb(): Long

    @Query("SELECT Count(*) from author")
    fun getAmountOfAuthorsInDb(): Long
}