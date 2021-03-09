import client.MacroCommand
import client.NeoRemoteControl
import client.RemoteControl
import client.SimpleRemoteControl
import concretecommand.GarageDoorCloseCommand
import concretecommand.GarageDoorOpenCommand
import concretecommand.LightOffCommand
import concretecommand.LightOnCommand
import concreteneocommand.*
import receiver.CeilingFan
import receiver.GarageDoor
import receiver.Light

fun main() {
    /*===Command Pattern 1===*/
    /*val remote = SimpleRemoteControl()
    val light = Light("Living Room")
    val lightOn = LightOnCommand(light)
    //val garageDoor = GarageDoor()
    //val garageDoorOpenCommand = GarageDoorOpenCommand(garageDoor)

    remote.setCommand(lightOn)
    //remote.setCommand(garageDoorOpenCommand)
    remote.buttonWasPressed()
    remote.buttonWasPressed()*/

    /*===Command Pattern 2===*/
    /*val remoteControl = RemoteControl()
    
    val kitchenLight = Light("Kitchen")
    val livingroomLight = Light("LivingRoom")
    
    val kitchenLightOnCommand = LightOnCommand(kitchenLight)
    val kitchenLightOffCommand = LightOffCommand(kitchenLight)
    val livingroomLightOnCommand = LightOnCommand(livingroomLight)
    val livingroomLightOffCommand = LightOffCommand(livingroomLight)
    
    remoteControl.setCommand(0, kitchenLightOnCommand, kitchenLightOffCommand)
    remoteControl.setCommand(1, livingroomLightOnCommand, livingroomLightOffCommand)
    
    println(remoteControl.commandListToString())
    
    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    remoteControl.onButtonWasPushed(1)
    remoteControl.offButtonWasPushed(1)*/

    /*===UNDO 1===*/
    /*val remoteControl = NeoRemoteControl()
    
    val kitchenLight = Light("Kitchen")
    val livingroomLight = Light("LivingRoom")
    
    val neoKitchenLightOnCommand = NeoLightOnCommand(kitchenLight)
    val neoKitchenLightOffCommand = NeoLightOffCommand(kitchenLight)
    val neoLivingroomLightOnCommand = NeoLightOnCommand(livingroomLight)
    val neoLivingroomLightOffCommand = NeoLightOffCommand(livingroomLight)
    
    remoteControl.setCommand(0, neoKitchenLightOnCommand, neoKitchenLightOffCommand)
    remoteControl.setCommand(1, neoLivingroomLightOnCommand, neoLivingroomLightOffCommand)
    
    println(remoteControl.commandListToString())
    
    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    println("===========================")
    //println(remoteControl.commandListToString())
    remoteControl.undoButtonWashPushed()
    remoteControl.undoButtonWashPushed()
    remoteControl.undoButtonWashPushed()

    println("===========================")
    
    remoteControl.offButtonWasPushed(1)
    remoteControl.onButtonWasPushed(1)
    println("===========================")
    //println(remoteControl.commandListToString())
    remoteControl.undoButtonWashPushed()*/

    /*===UNDO 2===*/
    /*val remoteControl = NeoRemoteControl()

    val livingroomCeilingFan = CeilingFan("Living Room")

    val neoCeilingFanHigh = NeoCeilingFanHighCommand(livingroomCeilingFan)
    val neoCeilingMediumHigh = NeoCeilingFanMediumCommand(livingroomCeilingFan)
    val neoCeilingOffHigh = NeoCeilingFanOffCommand(livingroomCeilingFan)
    
    remoteControl.setCommand(0, neoCeilingFanHigh, neoCeilingOffHigh)
    remoteControl.setCommand(1, neoCeilingMediumHigh, neoCeilingOffHigh)

    println(remoteControl.commandListToString())

    println("===========================")

    remoteControl.onButtonWasPushed(0)
    remoteControl.offButtonWasPushed(0)
    //println(remoteControl.commandListToString())
    remoteControl.undoButtonWashPushed()

    println("===========================")
    
    remoteControl.onButtonWasPushed(1)
    //println(remoteControl.commandListToString())
    remoteControl.undoButtonWashPushed()*/

    /*===MACRO===*/
    val remoteControl = RemoteControl()

    val light = Light("Living Room")
    val garageDoor = GarageDoor()
    
    val lightOnCommand = LightOnCommand(light)
    val lightOffCommand = LightOffCommand(light)
    val garageDoorOpenCommand = GarageDoorOpenCommand(garageDoor)
    val garageDoorCloseCommand = GarageDoorCloseCommand(garageDoor)

    val comingHome = arrayOf(lightOnCommand, garageDoorCloseCommand)
    val leavingHome = arrayOf(lightOffCommand, garageDoorOpenCommand)
    
    val comingHomeMacro = MacroCommand(comingHome)
    val leavingHomeMacro = MacroCommand(leavingHome)
    
    remoteControl.setCommand(0, comingHomeMacro, leavingHomeMacro)
    remoteControl.onButtonWasPushed(0)
    println("==========================")
    remoteControl.offButtonWasPushed(0)
}