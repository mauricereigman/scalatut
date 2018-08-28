package AssignmentD.services

import Done.models.{ApplicationMovie, OmdbMovie}
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.libs.ws.WSClient

import scala.concurrent.{ExecutionContext, Future}

class OmdbMovieService @Inject()(implicit val ec: ExecutionContext,
                                 ws: WSClient) {

  private def movie(searchQuery: String): Future[OmdbMovie] = ws.url(s"http://www.omdbapi.com/?apikey=e36ea2a2&t=$searchQuery")
    .addHttpHeaders("Accept" -> "application/json")
    .get()
    .map(result => Json.parse(result.body).as[OmdbMovie])

  def movies(searchQuery: String): Future[Seq[ApplicationMovie]] = movie(searchQuery).map(movie => Seq(movie.toApplicationModel))
}

