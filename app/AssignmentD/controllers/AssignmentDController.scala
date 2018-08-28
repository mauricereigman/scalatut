package AssignmentD.controllers

import AssignmentD.models.{GoodMovie, Movie}
import AssignmentD.utils.AssignmentDExtensions._
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

import scala.concurrent.Future

/** Assignment B goal: 'working with futures(monads)'
  * D.1 instead of using data created by ourselves you can see that we are now getting our movie data from an external (OMDB) rest service
  * what we get from this service is a Future of movies. a future is a monad just like the sequence we have been using so far so this should be easy.
  * Also a future is very much comparable to a promise in javascript this should also help
  * use exampleMovies1Future instead of exampleMovies1
  * **/

class AssignmentDController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  private val exampleMovies1: Seq[Movie] = Seq(
    Movie(
      title = "blade",
      releaseDate = "21 Aug 1998",
      actors = "Wesley Snipes, Stephen Dorff, Kris Kristofferson, N'Bushe Wright"
    )
  )
  private def splitActors: Movie => Seq[String] = (movie: Movie) => movie.actors.toSequence

  private def goodMovies:Seq[GoodMovie] = exampleMovies1.map(movie =>
    GoodMovie(actors = splitActors(movie), title = movie.title, releaseDate = movie.releaseDate).copy(title = movie.title.toUpperCase))

  def movies = Action {
    Ok(Json.toJson(goodMovies))
  }

}