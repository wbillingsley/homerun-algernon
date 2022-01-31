package homerun.server

import akka.actor.typed.scaladsl.Behaviors
import akka.actor.typed.ActorSystem

given system:ActorSystem[Any] = akka.actor.typed.ActorSystem(Behaviors.empty, "TheSystem")

@main def main():Unit = {
    
}