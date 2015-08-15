package functions

import utils.RootException

case class HttpException(m: String) extends RootException

object HttpFunction {
  def fetch(): Either[HttpException, String] = Left(HttpException("http error"))
}

