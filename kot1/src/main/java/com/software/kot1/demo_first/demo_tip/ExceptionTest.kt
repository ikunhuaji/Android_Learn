package com.software.kot1.demo_first.demo_tip

import com.software.kot1.demo_first.demo_interface.Study

class Student(): Study {
    override fun study() {//实现接口抽象方法
        println("study")
    }

    override fun readBooks() {}

    override fun doHomework() {}

}

// test1 第一个会因为空参数报错
//fun study(study : Study){
//    study.study()//会调用study对象自身的study函数
//}

// test2 无法运行 , Study? 表示传入的参数可为 null , 代码报错 , 无法编译
//fun study(study: Study?){
//    study.study()
//}

// test3 可运行两个 , ?. 表示 ? 前的对象不为空 , 才执行 . 后的方法
fun study(study: Study?){
    study?.study()
}

// test4 通过 !! 强行编译，会抛出异常
//fun study(study: Study?) {
//    //假设此时为空抛出异常，则和java一样
//    study!!.study()
//}

// ?: 表示 当 ? 前的不为 null 则返回 ? 前的值 , 否则返回 ? 后的值
fun notNull(a: Int?, b:Int) = a ?: b

fun getTextLength(text : String?) = text?.length ?: 0

// let 函数 ,

fun main(){
    study(null)//除非过滤，否则报错 Kotlin 传入的参数和遍量不能为空
    study(Student())

    println(notNull(null, 114514))

    println(getTextLength(""))


}