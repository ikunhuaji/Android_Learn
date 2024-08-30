package com.software.kot1.demo_first.demo_function

import kotlin.system.exitProcess

//四则运算模拟

fun main(){
    while (true){
        println("===================")
        println("输入式子:")
        var input : String? = readln()
        try {
            input?.let{
                var res = caculate(it)
                println("${input} = ${res}")
                println("是否继续使用(y/n)")
                var cmd : String? = readln()
                cmd?.let{
                    if (it=="n"){
                        println("结束运行")
                        exitProcess(-1)
                    }else if (it == "y"){

                    }else{
                        println("回复错误,结束运行")
                        exitProcess(-1)
                    }
                }
            }
        }catch (e:Exception){
            e.printStackTrace()
        }
    }
}

fun caculate(input: String): String {
    if(input.contains("+")) {
        var nums: List<String> = input.trim().split("+")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "+").toString()
    }else if(input.contains("-")){
        var nums: List<String> = input.trim().split("-")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "-").toString()
    }else if(input.contains("/")){
        var nums: List<String> = input.trim().split("/")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "/").toString()
    }else if(input.contains("*")){
        var nums: List<String> = input.trim().split("*")
        return operate(nums[0].toDouble(), nums[1].toDouble(), "*").toString()
    }else{
        return "表达式有误"
    }
}

fun operate(num: Double, num2: Double , operate :String): Double {
    return when(operate){
        "+" -> num + num2
        "-" -> num - num2
        "/" -> num / num2
        "*" -> num * num2
        else -> 0.0
    }
}
