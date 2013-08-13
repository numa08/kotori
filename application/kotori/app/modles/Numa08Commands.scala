package models

import scala.sys.process._
import play.Logger

class Numa08Commands extends Command {

  def doIt():String = {
    val result = "rm -rf  /usr/local/www/numa08".###("git clone git@github.com:numa08/numa08.git ./numa08").###("mv ./numa08 /usr/local/www/numa08").!
    Logger.debug(result.toString)
    result.toString
  }

}
