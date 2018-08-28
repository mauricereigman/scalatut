package Done.controllers

import Done.models.{ApplicationMovie, OmdbMovie}
import Done.services.OmdbMovieService
import javax.inject.Inject
import play.api.libs.json.{Format, JsValue, Json, OWrites}
import play.api.mvc.{AbstractController, Action, AnyContent, ControllerComponents}

import scala.concurrent.{ExecutionContext, Future}

/** Assignment B goal: 'working with futures(monads)'
  * D.1 instead of using data created by ourselves you can see that we are now getting our movie data from an external (OMDB) rest service
  * what we get from this service is a Future of movies. a future is a monad just like the sequence we have been using so far so this should be easy.
  * Also a future is very much comparable to a promise in javascript this should also help
  * use exampleMovies1Future instead of exampleMovies1
  * NOTE!: the exampleMovies1Future contains a totally different object with different properties modify the goodMovies method accordingly
  * **/

class DoneController @Inject()(cc: ControllerComponents,
                               implicit val ec: ExecutionContext,
                               omdbMovieService: OmdbMovieService) extends AbstractController(cc) {

  private val exampleMovies1Future: Future[Seq[ApplicationMovie]] = omdbMovieService.movies(searchQuery = "blade")

  def movies:Action[AnyContent] = Action.async {
    exampleMovies1Future.map(exampleMovies1 => Ok(Json.toJson(exampleMovies1)))
  }
}
