package concreteneocommand

import command.NeoCommand

class NeoNoCommand : NeoCommand {
    
    override fun undo() {}

    override fun execute() {}
}