package com.software.kot1.demo_first.demo_and_class

fun main(){
    //基本数据类型 整型 ， 浮点 ， 字符 ， 布尔
    // 整型 Byte ： 8  ，  Short ： 16 ， Int ： 32 ， Long ： 64
    // 浮点和c一样
    // 其他和JAVA一样

    //float 精度6位 超过部分四舍五入
    var f : Float =  3.1415928888f
    println(f)

    //字符串
    var str : String = "12345"
    println("The str is $str")
    println("The str is " + str)
    println("The str is ${str.length}")
}