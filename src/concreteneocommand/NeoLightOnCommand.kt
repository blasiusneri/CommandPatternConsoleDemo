package concreteneocommand

import command.NeoCommand
import receiver.Light

class NeoLightOnCommand(private val light: Light) : NeoCommand {
    
    override fun undo() {
        light.off()
    }

    override fun execute() {
        light.on()
    }

}