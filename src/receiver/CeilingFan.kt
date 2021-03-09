package receiver

class CeilingFan(private val location: String) {
    
    companion object {
        const val HIGH = 3
        const val MEDIUM = 2
        const val LOW = 1
        const val OFF = 0
    }
    
    private var speed: Int? = null
    
    init {
        speed = OFF
    }
    
    fun high() {
        speed = HIGH
        println("Ceiling fan speed is high")
    }

    fun medium() {
        speed = MEDIUM
        println("Ceiling fan speed is medium")
    }

    fun low() {
        speed = LOW
        println("Ceiling fan speed is low")
    }

    fun off() {
        speed = OFF
        println("Ceiling fan speed is off")
    }
    
    fun getSpeed() = speed
    
}