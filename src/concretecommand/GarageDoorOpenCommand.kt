package concretecommand

import command.Command
import receiver.GarageDoor

class GarageDoorOpenCommand(private var garageDoor: GarageDoor) : Command {
    
    override fun execute() {
        garageDoor.up()
        garageDoor.lightOn()
    }

}