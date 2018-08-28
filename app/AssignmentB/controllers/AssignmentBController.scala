package AssignmentB.controllers

import AssignmentA.models.Movie
import javax.inject.Inject
import play.api.libs.json.Json
import play.api.mvc.{AbstractController, ControllerComponents}

/** Assignment B goal: 'working with the monad'
  * B.1 the Movie model has 3 properties. Lets name these in our arguments so we can read this without checking the model
  * note: this also has the direct advantage of not having to worry about the
  * order of the arguments sins they are named this does not matter anymore;
  *
  * B.2 a sequence is (like most objects in scala) a monad. Lets use this feature to manipulate our data
  * Write a private method "def myMethod = () => {})" that turns the actors property into a
  * collection instead of a komma seperated string and implement the method using .map() on exampleMovies1;
  * return this in the def movies method so you get a JSON array of actors
  * check localhost:9000/assignmentB for the result
  *
  * B.3 lets take this a step further sinds we have only been using the movies as a functor up until now lets use the big monad feature "flatMap".
  * exampleMovies2 is a 2 dimensional collection (e.g a collection of collections) use the same method you created above
  * but now do it on the exampleMovies2
  *
  * tags:
  * named arguments, monad
  * **/

class AssignmentBController @Inject()(cc: ControllerComponents) extends AbstractController(cc) {
  private val exampleMovies1: Seq[Movie] = Seq(Movie("blade", "21 Aug 1998", "Wesley Snipes, Stephen Dorff, Kris Kristofferson, N'Bushe Wright"))
  private val exampleMovies2: Seq[Seq[Movie]] = Seq(Seq(Movie("blade", "21 Aug 1998", "Wesley Snipes, Stephen Dorff, Kris Kristofferson, N'Bushe Wright")))

  def movies = Action {
    Ok(Json.toJson(exampleMovies1))
  }
}