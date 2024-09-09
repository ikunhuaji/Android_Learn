package com.software.kot1.demo_first.demo_tip

import com.software.kot1.demo_first.demo_and_class.Person
import com.software.kot1.demo_first.demo_and_class.Student
import java.util.Scanner

fun main(){
    //类型强转

//    var a:Int = 67
//
//    var b:Number? = a as? Number//向上转换
//
//    println(a)
//    println(b)
//
//    if (b is Int){// b 是 Int 的父类
//        println(b)
//    }
//
//    println(a.toChar())

    println("输入一个10进制数字")

    var cin = Scanner(System.`in`)

    var n = cin.nextInt()

    var s:String = ""

    while(n>0){

        if(n.and(1)==1){
            s+="1"
        }else{
            s+="0"
        }

        n = n shr 1
    }

    s = s.reversed()
    println(s)

    println(s.replace('0', '2'))

    var ss = s.split('0')

    for (it in ss){
        println(it)
    }
}