package behavioral

// Subject (Observable)
interface Observable {
    fun registerObserver(observer: Observer)
    fun unregisterObserver(observer: Observer)
    fun notifyObservers()
}

// Concrete Subject
class WeatherStationObservable : Observable {
    private val observers: MutableList<Observer> = mutableListOf()
    private var temperature: Float = 0.0f

    // publish/emit values
    fun setTemperature(temperature: Float) {
        this.temperature = temperature
        // Notify to all Observers
        notifyObservers()
    }

    override fun registerObserver(observer: Observer) {
        observers.add(observer)
    }

    override fun unregisterObserver(observer: Observer) {
        observers.remove(observer)
    }

    override fun notifyObservers() {
        for (observer in observers) {
            observer.update(temperature)
        }
    }
}

// Observer
interface Observer {
    fun update(temperature: Float)
}

// Concrete Observer
class DisplayObserver(private val id: Int) : Observer {
    override fun update(temperature: Float) {
        println("Display$id: Temperature updated to $temperature")
    }
}