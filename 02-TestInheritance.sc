abstract class Shape
{
  def name : String
}

trait HasArea
{
  def area : Double
}

trait HasDiameter
{
  def diameter : Double
}

class Rectangle(val width : Double, val height : Double)
  extends Shape with HasArea with HasDiameter
{
  require(width > 0 && height > 0)

  private val w = width;
  private val h = height;
  override def name: String = "Rectangle"
  override def area: Double = this.w * this.h
  override def diameter: Double = 2 * (this.w + this.h)
  override def toString = "A = %.2f, D = %.2f".format(area, diameter)
}

object Square
{
  def apply(width: Double) = new Square(width)
}

class Square(width: Double, height: Double)
  extends Rectangle(width, height)
{
  require(width == height)
  def this(width: Double) = this(width, width)
  override def name: String = "Square"
}

class Circle(val radius : Double)
  extends Shape with HasArea with HasDiameter
{
  require(radius > 0)
  private val r = radius

  override def name: String = "Circle"
  override def area: Double = Math.PI * Math.pow(r, 2)
  override def diameter: Double = 2 * Math.PI * r
  override def toString = "A = %.2f, D = %.2f".format(area, diameter)
}

val rectangle = new Rectangle(3, 5)
println(rectangle)
//val square0 = new Square(3, 5)
val square1 = new Square(3.0)
println(square1)
val square2 = Square(3.0)
println(square2)
val circle = new Circle(2.0)
println(circle)

//Polymorphism
val shape0 = rectangle
val shape1 = square1
val shape2 = square2
val shape3 = circle

//Dynamic Binding
val shape = new Rectangle(9.0, 8.0)
println(shape)
var shapes = List[Shape](shape0, shape1, shape2, shape3)
shapes.foreach(println)

