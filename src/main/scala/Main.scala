import functions.{DatabaseFunction, HttpFunction, DatabaseAndHttpException}
import utils._



object Main {
  import utils.Implicit._
  import DatabaseAndHttpException._

  def main(args: Array[String]): Unit = {

    // this is DatabaseException
    val e3 = for {
      a <- DatabaseFunction.fetch()
    } yield ()
    println(e3.toString)

    // this is DatabaseAndHttpException
    val e4: Either[DatabaseAndHttpException, Unit] = for {
      a <- DatabaseFunction.fetch()
      b <- HttpFunction.fetch()
    } yield ()
    println(e4.toString)
  }
}
