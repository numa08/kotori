package net.numa08.kotori

import com.sun.akuma.Daemon

import play.core.server.NettyServer
import play.core.StaticApplication

import java.io._

object KotoriServer {

  def main(args:Array[String]){
    val daemon = new Daemon
    
    Option(System.getProperty("pidfile.path")).map(new File(_)).filter(p => !p.isDirectory) match {
      case Some(pidFile) => {
        if (daemon.isDaemonized) {
          daemon.init(pidFile.getAbsolutePath())
        } else {
          daemon.daemonize
          sys.exit(0)
        }

        new NettyServer(
          new StaticApplication(new File(args.headOption.getOrElse("user.dir"))),
          Option(System.getProperty("http.port")).map(_.toInt).getOrElse(9100),
          None,
          Option(System.getProperty("http.address")).getOrElse("0.0.0.0")
          )
      }
      case _ => {
        sys.error("Please select pid file")
        sys.exit(-1)
      }
    }

  }
}
