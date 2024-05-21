package behavioral

// Receiver
class Light {
    fun turnOn() {
        println("Light is turned on")
    }

    fun turnOff() {
        println("Light is turned off")
    }
}

// Command interface
interface Command {
    fun execute()
}

// Concrete command - TurnOnCommand
class TurnOnCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOn()
    }
}

// Concrete command - TurnOffCommand
class TurnOffCommand(private val light: Light) : Command {
    override fun execute() {
        light.turnOff()
    }
}

// Invoker/ Receiver
class RemoteControl {
    private var command: Command? = null

    fun setCommand(command: Command) {
        this.command = command
    }

    fun pressButton() {
        command?.execute()
    }
}