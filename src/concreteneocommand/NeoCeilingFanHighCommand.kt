package concreteneocommand

import command.NeoCommand
import receiver.CeilingFan

class NeoCeilingFanHighCommand(private val ceilingFan: CeilingFan) : NeoCommand {
    
    var prevSpeed: Int? = null
    
    override fun execute() {
        prevSpeed = ceilingFan?.getSpeed() 
        ceilingFan?.high()
    }

    override fun undo() {
        when (prevSpeed) {
            CeilingFan.HIGH -> {
                ceilingFan?.high()
            }
            CeilingFan.MEDIUM -> {
                ceilingFan?.medium()
            }
            CeilingFan.LOW -> {
                ceilingFan?.low()
            }
            CeilingFan.OFF -> {
                ceilingFan?.off()
            }
        }
    }
}