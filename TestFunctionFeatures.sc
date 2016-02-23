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

