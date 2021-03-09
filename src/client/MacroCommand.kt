package client

import command.Command
import command.NeoCommand

class MacroCommand(private val commands: Array<Command>) : Command {
    
    override fun execute() {
        for (command in commands) {
            command.execute()
        }
    }
}