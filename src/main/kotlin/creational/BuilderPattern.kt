package creational

data class Person private constructor(val name: String, val age: Int) {

    class Builder {
        private var name: String? = null
        private var age: Int? = null

        fun setName(name: String): Builder {
            this.name = name
            return this
        }

        fun setAge(age: Int): Builder {
            this.age = age
            return this
        }

        fun build(): Person {
            return Person(name!!, age!!)
        }
    }
}