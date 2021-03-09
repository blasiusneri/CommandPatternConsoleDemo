package client

import command.Command
import concretecommand.NoCommand

class RemoteControl {
    
    companion object {
        private const val ACTION_NUMBER = 7
    }
    
    private var onCommand = arrayOfNulls<Command>(ACTION_NUMBER)
    private var offCommand = arrayOfNulls<Command>(ACTION_NUMBER)
    
    init {
        for (i in 0..6) {
            onCommand[i] = NoCommand()
            offCommand[i] = NoCommand()
        }
    }
     
    fun setCommand(slot: Int, onCommand: Command, offCommand: Command) {
        this.onCommand[slot] = onCommand
        this.offCommand[slot] = offCommand
    }
    
    fun onButtonWasPushed(slot: Int) {
        onCommand[slot]?.execute()
    }

    fun offButtonWasPushed(slot: Int) {
        offCommand[slot]?.execute()
    }
    
    fun commandListToString(): String {
        var stringBuffer = StringBuffer()
        onCommand.forEachIndexed { index, element ->
            stringBuffer.append("slot $index ${onCommand[index]} ${offCommand[index]}\n")
        }
        return stringBuffer.toString()
    }
}