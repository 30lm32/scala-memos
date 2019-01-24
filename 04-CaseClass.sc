//This part completely was collected via the following link. https://stackoverflow.com/a/47072058/1925686
////1.Case Class doesn't need explicit new, while class need to be called with new
//
//val classInst = new MyClass(...)  // For classes
//val classInst = MyClass(..)       // For case class
//
////2.By Default constructors parameters are private in class , while its public in case class
//
//// For class
//class MyClass(x:Int) { }
//val classInst = new MyClass(10)
//
////classInst.x   // FAILURE : can't access
//
//// For caseClass
//case class MyClass(x:Int) { }
//val classInst = MyClass(10)
//
////classInst.x   // SUCCESS
////3.case class compare themselves by value
//
//// case Class
//class MyClass(x:Int) { }
//
//val classInst = new MyClass(10)
//val classInst2 = new MyClass(10)
//
////classInst == classInst2 // FALSE
//
//// For Case Class
//case class MyClass(x:Int) { }
//
//val classInst = MyClass(10)
//val classInst2 = MyClass(10)
//
////classInst == classInst2 // TRUE
