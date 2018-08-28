package Done.models

import play.api.libs.json.{Format, Json, OWrites, Reads}
import Done.utils.AssignmentDExtensions._

case class OmdbMovie(Title: String,
                     Year: String,
                     Rated: String,
                     Released: String,
                     Runtime: String,
                     Genre: String,
                     Director: String,
                     Writer: String,
                     Actors: String,
                     Plot: String,
                     Language: String,
                     Country: String,
                     Awards: String,
                     Poster: String,
                     Metascore: String,
                     imdbRating: String,
                     imdbVotes: String,
                     imdbID: String,
                     Type: String) {

   def toApplicationModel = ApplicationMovie(
    title = Title,
    year = Year,
    rated = Rated,
    released = Released,
    runtime = Runtime,
    genre = Genre,
    director = Director,
    writer = Writer,
    actors = Actors.toSequence,
    plot = Plot,
    language = Language,
    country = Country,
    awards = Awards,
    poster = Poster,
    metascore = Metascore,
    imdbRating = imdbRating,
    imdbVotes = imdbVotes,
    imdbId = imdbID,
    movieType = Type)
}


object OmdbMovie {
  implicit val omdbMovieWrites: OWrites[OmdbMovie] = Json.writes[OmdbMovie]
  implicit val omdbMovieReads: Reads[OmdbMovie] = Json.reads[OmdbMovie]
  implicit val jsonFormatToScalaModel: Format[OmdbMovie] = Json.format[OmdbMovie]
}
