package receiver

class Light(val location: String) {
    
    fun on() {
        println("$location Light On")
    }

    fun off() {
        println("$location light Off")
    }
}