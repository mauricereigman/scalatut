package AssignmentD.models

import play.api.libs.json.{Format, Json, OWrites}

case class Movie(title: String,
                 releaseDate: String,
                 actors: String)

object Movie {
  implicit val publWrites: OWrites[Movie] = Json.writes[Movie]
  implicit val jsonFormatToScalaObject: Format[Movie] = Json.format[Movie]
}
