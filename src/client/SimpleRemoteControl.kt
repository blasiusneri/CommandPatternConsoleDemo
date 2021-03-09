package client

import command.Command

class SimpleRemoteControl {
    
    private var slot: Command? = null
    
    fun setCommand(ICommand: Command) {
        slot = ICommand
    }
    
    fun buttonWasPressed() {
        slot?.execute()
    }
}