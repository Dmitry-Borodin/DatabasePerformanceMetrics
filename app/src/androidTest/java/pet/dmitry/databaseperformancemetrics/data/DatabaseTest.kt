package pet.dmitry.databaseperformancemetrics.data

import android.support.test.InstrumentationRegistry
import android.support.test.runner.AndroidJUnit4
import android.util.Log
import androidx.room.Room
import org.junit.After
import org.junit.Assert.assertEquals
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith
import pet.dmitry.databaseperformancemetrics.di.DependencyGraph

/**
 * @author Dmitry Borodin on 1/13/19.
 */
@RunWith(AndroidJUnit4::class)
class DatabaseTest {

    private lateinit var database: Database

    @Before
    fun setUp() {
        Log.e("my", "before")
        database = Room.inMemoryDatabaseBuilder(
            InstrumentationRegistry.getContext(),
            Database::class.java
        ).build()
    }

    @After
    fun tearDown() {
        database.close()
    }

    @Test
    fun shouldPersistSongs() {
        val authorId: Long = 10
        val songs = DependencyGraph.appScope.generator.generateSongs(10, authorId)

        database.getSongDao().insertSongs(songs)
        val restoredSongs = database.getSongDao().getSongsOfAuthor(authorId)
        assertEquals(songs, restoredSongs)
    }

    @Test
    fun shouldReturnAmountOfSavedAuthors() {
        val authors = DependencyGraph.appScope.generator.generateAuthors(13)

        database.getSongDao().insertAuthors(authors)
        val amountofAuthors = database.getSongDao().getAmountOfAuthorsInDb()
        assertEquals(authors.size.toLong(), amountofAuthors)
    }

    @Test
    fun shouldReturnAmountOfSavedSongs() {
        val authorId: Long = 10
        val songs = DependencyGraph.appScope.generator.generateSongs(12, authorId)

        database.getSongDao().insertSongs(songs)
        val amount = database.getSongDao().getAmountOfSongsInDb()
        assertEquals(songs.size.toLong(), amount)
    }
}