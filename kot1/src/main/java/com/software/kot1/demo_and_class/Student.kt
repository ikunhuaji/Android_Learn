package com.software.kot1.demo_and_class

import com.software.kot1.demo_interface.Study

//test1
//class Student : Person() {
//    var number = ""
//    var grade = 0
//    fun study(){
//        println(name + " is studying")
//    }
//}

//test2
//继承主构造Person的Student主构造
//class Student(name :String,age:Int,var number: String,var grade:Int):Person(name,age){
//    constructor(name: String,age: Int,number: String):this(name,age,number,0){//形如 Student(name,age,number,0)为三参构造
//
//    }
//    constructor():this("",0,"",0){//形如 Student("",0,"",0)为无参构造
//
//    }
//}

//写法2 把构造的参数当形参使用
//class Student(name :String,age:Int,number: String,grade:Int):Person(name,age){
//    constructor(name: String,age: Int,number: String):this(name,age,number,0){//形如 Student(name,age,number,0)为三参构造
//
//    }
//    constructor():this("",0,"",0){//形如 Student("",0,"",0)为无参构造
//
//    }
//
//    var number : String = number + "L"//等号后面为主构造的参数
//    var grade : Int = grade+1
//}

//test3 无主构造
//class Student : Person{
//    constructor(name:String,age:Int,number: String):super(name,age){
//
//    }
//
//    fun study(){
//        //name,age可以引用
//        println(name+"'s age is "+age+". study")
//
//        println(number)//报错
//        //因为number不是主构造参数
//    }
//}

//test4 使用接口
class Student(name:String,age:Int,var number: String,var grade:Int):Person(name,age),Study{
    override fun study() {//实现接口抽象方法
        println("study")
    }

    override fun readBooks() {}

    override fun doHomework() {}

}