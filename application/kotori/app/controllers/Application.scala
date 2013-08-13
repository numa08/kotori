package controllers

import models._

import play.api._
import play.api.mvc._

import scala.util.control.Exception._

object Application extends Controller {

  lazy val commands = Map("numa08" -> new Numa08Commands)
  
  def hook(name:String) = Action {
    commands.get(name).map( command => {
      allCatch either command.doIt() match {
        case Left(e) => NotImplemented(e.getMessage)
        case Right(u) => Ok
      }
      }).getOrElse(BadRequest)
  }
}
