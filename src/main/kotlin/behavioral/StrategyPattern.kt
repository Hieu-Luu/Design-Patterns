package behavioral

// Strategy interface
interface PaymentStrategy {
    fun pay(amount: Double)
}

// Concrete strategies
class CreditCardPaymentStrategy(private val cardNumber: String, private val cvv: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount using credit card $cardNumber")
    }
}

class PayPalPaymentStrategy(private val email: String, private val password: String) : PaymentStrategy {
    override fun pay(amount: Double) {
        println("Paying $amount using PayPal account $email")
    }
}

//Context
class ShoppingCart(private var paymentStrategy: PaymentStrategy) {
    fun change(strategy: PaymentStrategy) {
        this.paymentStrategy = strategy
    }

    fun checkout(amount: Double) {
        paymentStrategy.pay(amount)
    }
}