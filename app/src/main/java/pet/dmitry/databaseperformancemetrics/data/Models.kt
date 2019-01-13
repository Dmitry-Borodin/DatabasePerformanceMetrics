package pet.dmitry.databaseperformancemetrics.data

import androidx.room.Entity
import androidx.room.PrimaryKey

/**
 * @author Dmitry Borodin on 1/13/19.
 */

@Entity
data class Song(
    @PrimaryKey val id: Long,
    val name: String,
    val authorId: Long,
    val url: String
)

@Entity
data class Author(
    @PrimaryKey
    val id: Long,
    val name: String,
    val homePage: String
)