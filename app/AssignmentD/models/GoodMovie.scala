package AssignmentD.models

import play.api.libs.json.{Json, OWrites}

case class GoodMovie(title: String,
                     releaseDate: String,
                     actors: Seq[String])

object GoodMovie {
  implicit val publWrites: OWrites[GoodMovie] = Json.writes[GoodMovie]
}
