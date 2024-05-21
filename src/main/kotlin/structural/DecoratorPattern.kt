package structural

// Component interface
interface Coffee {
    fun getCost(): Double
    fun getDescription(): String
}

// Concrete component class
class SimpleCoffee : Coffee {
    override fun getCost(): Double {
        return 1.0
    }

    override fun getDescription(): String {
        return "Simple Coffee"
    }
}

// Decorator class
abstract class CoffeeDecorator(private val decoratedCoffee: Coffee) : Coffee {
    override fun getCost(): Double {
        return decoratedCoffee.getCost()
    }

    override fun getDescription(): String {
        return decoratedCoffee.getDescription()
    }
}

// Concrete decorator class
class Milk(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.5
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Milk"
    }
}

// Concrete decorator class
class Whip(coffee: Coffee) : CoffeeDecorator(coffee) {
    override fun getCost(): Double {
        return super.getCost() + 0.7
    }

    override fun getDescription(): String {
        return super.getDescription() + ", Whip"
    }
}
