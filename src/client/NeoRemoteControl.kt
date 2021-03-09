package client

import command.NeoCommand
import concreteneocommand.NeoNoCommand

class NeoRemoteControl {
    
    companion object {
        private const val ACTION_NUMBER = 7
    }
    
    private var onCommand = arrayOfNulls<NeoCommand>(ACTION_NUMBER)
    private var offCommand = arrayOfNulls<NeoCommand>(ACTION_NUMBER)
    private var undoCommand: NeoCommand? = null
    
    init {
        for (i in 0..6) {
            onCommand[i] = NeoNoCommand()
            offCommand[i] = NeoNoCommand()
        }
        undoCommand = NeoNoCommand()
    }
     
    fun setCommand(slot: Int, onCommand: NeoCommand, offCommand: NeoCommand) {
        this.onCommand[slot] = onCommand
        this.offCommand[slot] = offCommand
    }
    
    fun onButtonWasPushed(slot: Int) {
        onCommand[slot]?.execute()
        undoCommand = onCommand[slot]
    }

    fun offButtonWasPushed(slot: Int) {
        offCommand[slot]?.execute()
        undoCommand = offCommand[slot]
    }
    
    fun undoButtonWashPushed() {
        undoCommand?.undo()
    }
    
    fun commandListToString(): String {
        var stringBuffer = StringBuffer()
        onCommand.forEachIndexed { index, element ->
            stringBuffer.append("slot $index ${onCommand[index]} ${offCommand[index]}\n")
        }
        return stringBuffer.toString()
    }
}