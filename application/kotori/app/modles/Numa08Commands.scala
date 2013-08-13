package models

import scala.sys.process._

class Numa08Commands extends Command {

  def doIt() {
    "/bin/bash -c cd /usr/local/www/numa08 && /usr/bin/git pull origin master".run
  }

}
