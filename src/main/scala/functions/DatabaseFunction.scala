package functions

import utils.RootException

case class DatabaseException(m: String) extends RootException

object DatabaseFunction {
  def fetch(): Either[DatabaseException, String] = Left(DatabaseException("db error"))
}