package com.software.kot1.demo_stl

//与 List 类似
fun main(){
    //不可变 setof
    var set1 = setOf<String>("ab","aa","ba","a","aaa","a")
    println(set1)

    //可变
    var set2 = mutableSetOf<String>("ab","aa","ba","a","aaa","a")
    set2.add("hello")
    println(set2)

    for(item in set1){
        println(item + " ok")
    }
}