package structural

// Complex subsystem classes
class SubSystemA {
    fun operationA() {
        println("SubsystemA: Operation A")
    }
}

class SubsystemB {
    fun operationB() {
        println("SubsystemB: Operation B")
    }
}

class SubsystemC {
    fun operationC() {
        println("SubsystemC: Operation C")
    }
}

class Facade(private val subSystemA: SubSystemA, private val subsystemB: SubsystemB, private val subsystemC: SubsystemC) {
    fun doSomething() {
        subSystemA.operationA()
        subsystemB.operationB()
        subsystemC.operationC()
    }
}