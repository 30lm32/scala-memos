//0-Internal Function ==============================
def fog(x : Int) =
{
  def g(x : Int) =  2 * x
  g(x) + 2
}
var r = fog(2)
//1-Partially Applied Function ===============================
def fog1(g : Int => Int)(x : Int) = g(x) + 2
var r1 = fog1(x => 2 * x) _
r1(2)
val fog2 : (Int => Int, Int) => Int = _ (_) + 2
val r2 = fog2(_ , _)
r2(x => 2 * x, 2)

//val fog5 : (Int => (Int => Int)) => Int = _
//val r5 = fog5(_)
//r5(x => y => 2)
def fog3(g : Int => Int, x : Int) = g(x) + 2
val r3 = fog3(x => 2 * x, _ : Int)
//2-Closures - First-class Functions  ==============
val a = 2
val b = 5
def y(x : Int) = a * x + b //Closure
y(4)
var fcf = (x : Int) => x + 1 //First-class function
fcf(6)

val v0 : ((Int, Int) => Int) = _ + _
val v1 = (_ : Int) + (_ : Int)
val v2 = (x : Int, y : Int) => x + y
val compareVs0 = v0(1, 2) == v1(1, 2) == (v1(1, 2) == v2(1, 2))
//3-Higher-order Functions  ========================
def fog4(x : Int, g : Int => Int) = g(x) + 2
def r4(x : Int) = fog4(x, y => 2 * y)
r4(2)
//4-Curring Functions
def f(x: Int)(y: Int) = x + y
var first = f(1)_ //_ is one of partial function
var second = first(2)
//4-Pass Parameter by using curly braces
def fog5(x : Int)(g : Int => Int) = g(x) + 2
val r5 = fog5(2)
{
  x => 2 * x
}

//5-By-name Parameters
def fog6(x: Int)(g : => Int) = g + 2
val r6 = (x : Int) => fog6(x){x * 2}
r6(2)
def fog7(g: => Int) = g + 2
val r7 = (x : Int) => fog7{x * 2}
r7(2)
//
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