package concretecommand

import command.Command
import receiver.GarageDoor

class GarageDoorCloseCommand(private var garageDoor: GarageDoor) : Command {
    
    override fun execute() {
        garageDoor.down()
        garageDoor.lightOff()
    }

}