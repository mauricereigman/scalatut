package AssignmentA.controllers

import AssignmentA.models.Movie
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

/** Assignment A goal: 'getting the machine going(warm up)'
  * A.1 create a Movie and place it in the exampleMovies val, check localhost:9000/assignmentA for the result (should be broken)
  * A.2 use an implicit to convert the Movie case class to a JSON object do this in the movie model, check localhost:9000/assignmentA for the result
  *
  * tags:
  * implicits, case class, companion object
  * **/

class AssignmentAController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {

  private val exampleMovies: Seq[Movie] = Seq() // create a movie and place it in the sequence

  def movies = Action {
    Ok(Json.toJson(exampleMovies))
  }

}