package controllers

import models._

import play.api._
import play.api.mvc._

object Application extends Controller {

  lazy val commands = Map("numa08" -> new Numa08Commands)
  
  def hook(name:String) = Action {
    val command = commands(name)
    command.doIt
    Ok(name)
  }
}
