package com.software.kot1.demo_and_class

fun main(){
    var range = 0..10//range为区间 [0,10]

    for(i in range){
        println(i)
    }

    for(i in 0 until 10){// until 右侧为开区间
        println(i)
    }

    for(i in 0 until 10 step 2){// +=2
        println(i)
    }

    for(i in 10 downTo 1){//降序循环
        println(i)
    }


}