package command

interface NeoCommand {
    fun execute()
    fun undo()
}