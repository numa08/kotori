package controllers

import models._

import play.api._
import play.api.mvc._

object Application extends Controller {

  lazy val commands = Map("numa08" -> new Numa08Commands)
  
  def hook(name:String) = Action {
    commands.get(name) match {
      case Some(command) => command.doIt();Ok(name)
      case None => BadRequest
    }
  }
}
