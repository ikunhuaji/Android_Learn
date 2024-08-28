package com.software.kot1.demo_thread

fun main(){
    Thread(object : Runnable{
        override fun run() {
            println("完整")
        }

    }).start()

    //简化1
    Thread(Runnable {
        println("简化1")
    }).start()

    //简化2
    Thread{
        println("简化2")
    }.start()
}