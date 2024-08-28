package com.software.kot1.demo_stl

fun main(){
    //无参创建
    var lsit = ArrayList<Int>()
    lsit.add(1)
    lsit.add(2)
    lsit.remove(1);

    //不可改变只能查询的 listof , 创建不可变的已知列表
    var list1 = listOf<Int>(1,2,3,4,5)
//    lsit1.add(6)//报错

    //后续可改变的 mutableListOf , 创建可变的已知列表
    var list2 = mutableListOf<Int>(1,2,3,4,5)
    list2.add(6)

    //加强for循环遍历
    for (item in list2){
        println(item)
    }

    //lambda 查询长度最大的元素
    var strlist = listOf<String>("a","ab","aab","abc")
    var lambda = {str:String -> str.length}
    var maxn1 = strlist.maxBy(lambda)

    //lambda 查询大小最大 , 省略写法
    var maxn2 = strlist.maxBy{it}

    println(maxn1 + " " + maxn2)
}