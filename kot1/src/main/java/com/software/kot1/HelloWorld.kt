package com.software.kot1

fun add(a:Int,b:Int):Int{
    return  a+b
}

//fun add(a:Int,b:Int) : Int = a+b //直接声明
//fun add(a:Int,b:Int) = a+b //类型推导省略

fun max(a:Int,b: Int) = if ( a > b ) a else b //Kotlin没有三目

fun change1(x: Int) = if (x == 114514) "man!"
else "What can I say?"

//Kotlin 中 == 等价于Java的 equals 比较的时是对象里的内容， === 等价于 Java 的 == ，比较的为对象的引用

fun change2(x: Int) = when(x){
    114514 -> "man!"
    1919810 -> "What can I say?"
    else -> "非法"//没有 else 会报错
}

fun getScore(name: String) = when {//写法2
    name == "Tom"  -> "不及格"
    name == "Jim" -> "及格"
    name == "Pony" -> "良好"
    name == "Tony" -> "优秀"
    else -> "名字非法"
}

fun check(num:Number){//when判断数据类型
    when(num){
        is Int -> println("Int")
        is Double -> println("Double")
        else -> print("others")
    }
}

fun main(){
//    println("Hello World!")

    var a = 1114514
    var b: Int = 1919810

    println(a+b)
    println(max(a,b))


}
