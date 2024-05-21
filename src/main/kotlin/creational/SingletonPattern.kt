package creational

class OnlyMe private constructor() {
    companion object {
        private var instance: OnlyMe? = null

        fun getInstance(): OnlyMe {
            if (instance == null) {
                instance = OnlyMe()
            }
            return instance as OnlyMe
        }
    }

    fun whoIam() {
        println("Who I am: $instance")
    }
}