package homerun.model

trait ClientMessage

enum Command extends ClientMessage:
  case Ping
  case GitClone(url:String)
