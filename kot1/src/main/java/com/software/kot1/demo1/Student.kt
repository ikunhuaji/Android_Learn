package com.software.kot1.demo1

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
class Student(name :String,age:Int,var number: String,var grade:Int):Person(name,age){
    constructor(name: String,age: Int,number: String):this(name,age,number,0){//形如 Student(name,age,number,0)为三参构造

    }
    constructor():this("",0,"",0){//形如 Student("",0,"",0)为无参构造

    }
}