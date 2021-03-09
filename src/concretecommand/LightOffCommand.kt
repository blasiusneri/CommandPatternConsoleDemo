package concretecommand

import command.Command
import receiver.Light

class LightOffCommand(private val light: Light) : Command {
    
    override fun execute() {
        light.off()
    }

}