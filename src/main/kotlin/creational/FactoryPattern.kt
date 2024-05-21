package creational

interface Product {
    fun doSomething()
}

class ConcreteProductA: Product {
    override fun doSomething() {
        println("ProductA is doing something.")
    }
}

class ConcreteProductB: Product {
    override fun doSomething() {
        println("ProductB is doing something.")
    }
}

class ProductFactory {
    fun createProduct(type: String): Product {
        return when(type) {
            "A" -> ConcreteProductA()
            "B" -> ConcreteProductB()
            else -> throw IllegalArgumentException("Invalid product type: $type")
        }
    }
}