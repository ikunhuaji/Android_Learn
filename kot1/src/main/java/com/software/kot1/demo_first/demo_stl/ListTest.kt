package com.software.kot1.demo_first.demo_stl

import androidx.compose.ui.text.toUpperCase

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
    var strList = listOf<String>("a","ab","aab","abc")
    var lambda = {str:String -> str.length}
    var maxn1 = strList.maxBy(lambda)

    //lambda 查询大小最大 , 省略写法
    var maxn2 = strList.maxBy{it}

    println(maxn1 + " " + maxn2)

    // map 映射 , 小写转大写
    var newList = strList.map{ it.toUpperCase() }
    println(newList)

    // filter 过滤 , 筛出长度>=3的元素
    newList = strList.filter { it.length >= 3 }
    println(newList)

    // any 返回boolen , 是否存在满足条件元素
    var isAny = strList.any { it.length>3 }
    println(isAny)

    // all 返回boolen , 是否所有元素都满足条件
    var isAll = strList.all { it >= "a" }
    println(isAll)
}