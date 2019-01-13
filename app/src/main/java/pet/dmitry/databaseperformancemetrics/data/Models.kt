package pet.dmitry.databaseperformancemetrics.data

/**
 * @author Dmitry Borodin on 1/13/19.
 */


data class Song(val id: Long, val name: String, val authorId: Long, val url: String)

data class Author(val id: Long, val name: String, val homePage: String)