package Done.models

import play.api.libs.json.{Json, OWrites}

case class ApplicationMovie(title: String,
                            year: String,
                            rated: String,
                            released: String,
                            runtime: String,
                            genre: String,
                            director: String,
                            writer: String,
                            actors: Seq[String],
                            plot: String,
                            language: String,
                            country: String,
                            awards: String,
                            poster: String,
                            metascore: String,
                            imdbRating: String,
                            imdbVotes: String,
                            imdbId: String,
                            movieType: String)

object ApplicationMovie {
  implicit val ApplicationMovieJsonWrites: OWrites[ApplicationMovie] = Json.writes[ApplicationMovie]
}
