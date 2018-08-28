package AssignmentA.models

import play.api.libs.json.{Json, OWrites}

case class Movie(title: String,
                 releaseDate: String,
                 actors: String)

object Movie {
  //implicit val movieWrites: OWrites[Movie] = Json.writes[Movie]
}
