package com.software.kot1.demo_first.demo_stl

//fun change(index: Int , element: String) = index.toString() + " : " + element

fun transform(array : Array<String> , change : (index : Int , element : String) -> String){
    for(index in array.indices){//遍历下标
        var newItem = change(index,array[index])
        array[index]=newItem
    }
}

fun main(){

    var array1 : Array<Int?> = arrayOf(1,2,3,4,5)
//    array1[5]=2//报错
    println(array1)

//    创建空数组
    var array2 : Array<String?> = arrayOfNulls<String>(5)

    array2[0]="asdfad"
//    array2[5]="ada"//报错

    var array3 : Array<String> = arrayOf("a","b","c","d")

//    println(array3)

    transform(array3, change = {index, element ->  index.toString() + " : " + element})

//    println(array3)
}