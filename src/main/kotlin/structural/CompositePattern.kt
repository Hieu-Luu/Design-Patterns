package structural

// Component interface
interface Shape {
    fun draw()
}

// Leaf class (Individual object)
class Circle : Shape {
    override fun draw() {
        println("Drawing Circle")
    }
}

class Rectangle : Shape {
    override fun draw() {
        println("Drawing Rectangle")
    }
}

// Composite class (Group object)
class ShapeComposite : Shape {
    private val shapes: MutableList<Shape> = mutableListOf()

    fun addShape(shape: Shape) {
        shapes.add(shape)
    }

    fun removeShape(shape: Shape) {
        shapes.remove(shape)
    }

    override fun draw() {
        println("Drawing GroupShape")
        shapes.forEach { it.draw() }
    }
}