package concretecommand

import command.Command
import receiver.Light

class LightOnCommand(private val light: Light) : Command {
    
    override fun execute() {
        light.on()
    }

}