package models

import scala.sys.process._

class Numa08Commands extends Command {

  def doIt() {
    try {
      "cd /usr/local/www/numa08/ && git pull origin master".run
    } catch {
      case e:Exception => println("oh...")
    }
  }

}
