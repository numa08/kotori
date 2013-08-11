package models

import scala.sys.process._

class Numa08Commands extends Command {

  def command {
    "cd /usr/local/www/numa08/ && git pull origin master".run
  }

}
