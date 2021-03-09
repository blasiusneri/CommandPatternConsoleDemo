package concreteneocommand

import command.NeoCommand
import receiver.Light

class NeoLightOffCommand(private val light: Light) : NeoCommand {
    
    override fun undo() {
        light.on()   
    }

    override fun execute() {
        light.off()
    }

}