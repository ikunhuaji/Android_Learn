package com.software.kot1.demo_stl

fun main(){
    var map = HashMap<String,String>()
    map.put("1","zhangsan")
    map.put("2","lisi")

    //类似 C++
    map["3"]="wangwu"

    println(map["2"])
    println(map.get("1"))

    // 与 List 类似
    // mapof 不可变
    var map1 = mapOf<String,String>("1" to "zhangsan","2" to "lisi")
    //map1["3"]="wangwu"//报错

    // mutableMapOf 可变
    var map2 = mutableMapOf<String,String>("1" to "zhangsan","2" to "lisi")
    map2["3"]="wangwu"

    for((k,v) in map){
        println(k + " : " + v)
    }
}

