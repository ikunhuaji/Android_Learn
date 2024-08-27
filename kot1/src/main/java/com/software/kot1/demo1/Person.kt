package com.software.kot1.demo1

//test1
//open class Person {//默认为 final 不能继承，无参构造
//    var name = ""
//    var age = 0
//    fun printInfo(){
//        println(name+"'s age is "+age)
//    }
//}

//test2
open class Person(var name:String,var age:Int){//主构造写法
    init {//主构造处理
        println("name is"+name)
        println("age is"+age)
    }
}