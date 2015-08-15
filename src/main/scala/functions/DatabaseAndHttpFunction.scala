package functions

import utils._

case class DatabaseAndHttpException(m: String, cause: RootException) extends RootException
object DatabaseAndHttpException {
  implicit val databaseException = new ~>[DatabaseException, DatabaseAndHttpException] {
    def cast(a: DatabaseException) = DatabaseAndHttpException(s"database: ${a.m}", a)
  }

  implicit val httpException = new ~>[HttpException, DatabaseAndHttpException] {
    def cast(a: HttpException) = DatabaseAndHttpException(s"http: ${a.m}", a)
  }
}

object DataBaseAndHttpFunction {
  def fetch(): Either[DatabaseAndHttpException, String] = {
    for {
      a <- DatabaseFunction.fetch()
      b <- HttpFunction.fetch()
    } yield ()
  }
}