//new Int //It doesn't work since class Int is abstract
42.toString
42.hashCode
42 equals 42

var anyValue : AnyVal = 42
anyValue equals 42
anyValue = 42.0f
anyValue = 42.0
anyValue = 'c'
anyValue = print("test unit")
//The variable number can be assigned as a
//value instance of Double, Float, Long, Int, Short, Byte, Char, Boolean, Unit
//except for String since its super class is AnyVal.
//In other words, the class we typed is subclass of AnyVal

var anyRef : AnyRef = new String("abc")

var any = anyValue
//any = new String("abc") //It doesn't work!

def isEqual(x : Int, y : Int) = x == y;
isEqual(12, 12);

//In java the reference are checking instead of the below code
def isEqual(x : Any, y : Any) = x == y;

isEqual(12, 12);
isEqual('c', 'c');
isEqual("abc", "abc")

val s0 = new String("abc")
val s1 = new String("abc")

s0 == s1
s0 eq s1 //eq and ne are checking reference equality like == in Java
s0.eq(s1)
s0 ne s1
s0.ne(s1)
//
var b0 = s0.substring(2) == s1.substring(2) // true
var b1 = s0.substring(2) eq s1.substring(2) // false

42 max 45
42 min 45
0 until 10 //[0-10)
0 to 10 // [0-10]

(-20).abs


def error(message : String) : Nothing =
throw new RuntimeException(message)
def divide(x : Int, y : Int) : Int =
if(y != 0) x / y;
else error("Can't divide by zero")

var l = List[Int](1, 2, 3, 4)

//var re = divide(1, 0)

//re



