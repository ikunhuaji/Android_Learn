package com.software.kot1.demo_first.demo_tip

import com.software.kot1.demo_first.demo_and_class.Person
import com.software.kot1.demo_first.demo_and_class.Student

fun main(){
    //类型强转

    var a:Int = 67

    var b:Number? = a as? Number//向上转换

    println(a)
    println(b)

    if (b is Int){// b 是 Int 的父类
        println(b)
    }

    println(a.toChar())
}