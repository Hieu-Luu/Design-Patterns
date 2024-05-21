import behavioral.*
import behavioral.MediaPlayer
import creational.OnlyMe
import creational.Person
import creational.ProductFactory
import structural.*

fun main(args: Array<String>) {

    while (true) {
        println("Creational Patterns\n" +
                "1 - Builder pattern\n" +
                "2 - Singleton patten\n" +
                "3 - Factory pattern\n" +
                "Structural Patterns\n" +
                "4 - Adapter pattern\n" +
                "5 - Facade pattern\n" +
                "6 - Decorator pattern\n" +
                "7 - Composite pattern\n" +
                "Behavioral Patterns" +
                "8 - Command pattern\n" +
                "9 - Observer pattern\n" +
                "10 - Strategy pattern\n" +
                "11 - State pattern\n" +
                "0 - Exit")

        val choice = readln()
        when(choice.toInt()) {
            0 -> return

            // Creational Patterns
            1 -> {
                println("// Builder pattern //")
                val person = Person.Builder()
                    .setName("Neo")
                    .setAge(10)
                    .build()
                println(person)
            }
            2 -> {
                println("// Singleton pattern //")
                val object1 = OnlyMe.getInstance()
                object1.whoIam()
                val object2 = OnlyMe.getInstance()
                object2.whoIam()
                println("Are we the same instance of OnlyMe? ${object1 === object2}")
            }
            3 -> {
                println("// Factory pattern //")
                val factory = ProductFactory()
                val productA = factory.createProduct("A")
                productA.doSomething()
                val productB = factory.createProduct("B")
                productB.doSomething()
            }

            // Structural Patterns
            4 -> {
                println("// Adapter pattern //\n" +
                        "Allows objects with incompatible interfaces to work together.\n" +
                        "It converts the interfaces of an existing classes (or software) into one that a client (or service) expects.")
                val mediaPlayer = MediaPlayerAdapter(AdvancedMediaPlayer())
                mediaPlayer.play("vlc", "audio.vlc")
                mediaPlayer.play("mp4", "audio.mp4")
            }
            5 -> {
                println("// Facade pattern //\n" +
                        "Provide a simplified interface or entry point to a complex subsystem or set of classes.\n" +
                        "It encapsulates the complexity of the subsystem behind a single unified interface")
                val subsystemA = SubSystemA()
                val subsystemB = SubsystemB()
                val subsystemC = SubsystemC()

                val facade = Facade(subsystemA, subsystemB, subsystemC)
                facade.doSomething()
            }
            6 -> {
                println("// Decorator pattern //\n" +
                        "When you want to dynamically add or modify behavior to an object at runtime without altering its original implementation")
                val coffee: Coffee = SimpleCoffee()
                println("Cost: ${coffee.getCost()}, Description: ${coffee.getDescription()}")

                val coffeeWithMilk: Coffee = Milk(coffee)
                println("Cost: ${coffeeWithMilk.getCost()}, Description: ${coffeeWithMilk.getDescription()}")

                val coffeeWithMilkAndWhip: Coffee = Whip(coffeeWithMilk)
                println("Cost: ${coffeeWithMilkAndWhip.getCost()}, Description: ${coffeeWithMilkAndWhip.getDescription()}")
            }
            7 -> {
                println("// Composite pattern //\n" +
                        "When you want to treat a group of objects in a similar way as a single object.\n" +
                        "It allows to create hierarchical structures of objects where both individual objects and groups of objects can be treated uniformly.")
                val circle1: Shape = Circle()
                val circle2: Shape = Circle()

                val rectangle1: Shape = Rectangle()
                val rectangle2: Shape = Rectangle()

                val shapeComposite = ShapeComposite()
                shapeComposite.addShape(circle1)
                shapeComposite.addShape(circle2)
                shapeComposite.addShape(rectangle1)
                shapeComposite.addShape(rectangle2)

                shapeComposite.draw()
            }

            // Behavioral Patterns
            8 -> {
                val light = Light()

                val turnOnCommand = TurnOnCommand(light)
                val turnOffCommand = TurnOffCommand(light)

                val remoteControl = RemoteControl()
                remoteControl.setCommand(turnOnCommand)
                remoteControl.pressButton()

                remoteControl.setCommand(turnOffCommand)
                remoteControl.pressButton()
            }
            9 -> {
                val weatherStation = WeatherStationObservable()
                val display1 = DisplayObserver(1)
                val display2 = DisplayObserver(2)

                weatherStation.registerObserver(display1)
                weatherStation.registerObserver(display2)
                weatherStation.setTemperature(25.5f)

                // Only display2 receive new temperature value
                weatherStation.unregisterObserver(display1)
                weatherStation.setTemperature(30.0f)
            }
            10 -> {
                val creditCardStrategy = CreditCardPaymentStrategy("1234567890", "123")
                val payPalStrategy = PayPalPaymentStrategy("example@example.com", "password123")

                val shoppingCart = ShoppingCart(creditCardStrategy)
                shoppingCart.checkout(100.0)

                shoppingCart.change(payPalStrategy)
                shoppingCart.checkout(50.0)
            }
            11 -> {
                val mediaPlayer = MediaPlayer()

                mediaPlayer.play() // Starting player
                mediaPlayer.pause() // Pausing player
                mediaPlayer.pause() // Already paused
                mediaPlayer.stop() // Stopping player
                mediaPlayer.stop() // Already stopped
                mediaPlayer.play() // Starting player
                mediaPlayer.pause() // Pausing player
                mediaPlayer.play() // Resuming player
            }
        }
    }
}