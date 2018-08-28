package AssignmentC.controllers

import AssignmentA.models.Movie
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

/** Assignment B goal: 'getting to know implicits'
  * C.1 in assignment b we created a list of actors (you can check this out by going to localhost:9000/AssignmentC)
  * what we really want is to modify the movies object and return that instead.
  * create another movie model and call it GoodMovie. Make the format more manageable by making the actors property a collection type instead of a string
  *
  * C.2 take the movie in the exampleMovies1 and map it into a GoodMovie
  * collection so it now contains the list of actors and returns a GoodMovie in de movies method
  *
  * C.3 the conversion of a komma seperated list to a collection type is something we might do very often and does not only apply to a Movie.
  * lets create a extension method for doing this. Head over to utils/AssignmentCExtensions which adds a "splitByComma" method to a String type
  * HINT: extension method object have to be imported
  *
  * C.4 the immutable case class has no setters. To modify the GoodMovie model we can however use the ".copy(propToAlter = newVal)" method that
  * does a shallow copy and also gives you the option to modify certain properties while doing so.
  * modify the movies in the exampleMovies1 collection to capitilize the movie title property
  * HINT: objects instantiated by a case class are immutable and have a handy copy method which can also do modifications on the object
  *
  * tags:
  * extension methods through implicit class, implicit conversion, immutable case class
  * **/

class AssignmentCController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  private val exampleMovies1: Seq[Movie] = Seq(
    Movie(
      title = "blade",
      releaseDate = "21 Aug 1998",
      actors = "Wesley Snipes, Stephen Dorff, Kris Kristofferson, N'Bushe Wright"
    )
  )

  private def splitActors: Movie => Seq[String] = (movie: Movie) => movie.actors.split(",")

  def movies = Action {
    Ok(Json.toJson(exampleMovies1.map(splitActors)))
  }

}