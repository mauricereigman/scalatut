package Done.utils

object AssignmentDExtensions {
  implicit class collectionUtils(sequence: Seq[Any]) {
    /**
      * this is an example extension method added to the Sequence collection type that converts a Sequence to a string seperated by ";"
      **/
    def collectionToString: String = sequence.mkString(";")
  }

  implicit class stringUtils(string: String) {
    def toSequence: Seq[String] = string.split(",").toSeq
  }
  /**
    * create your extension class and method to convert a comma seperated String to a Sequence
    **/
}

