package com.yeonnex.lib

fun main(args: Array<String>){
    println("Function & Lambda")
    example00()
}



// 단일 표현식 함수 : 함수 실행 코드에 하나의 표현식만 있을 때
fun multiply(x: Int, y:Int) :Int = x*y

// 람다식: 독립적인 코드블록
// {<매개변수명>: <매개변수타입>, ... -><값을 반환하는 표현식>}
private fun example00() {
    val sayHello = {println("Hello")}
    sayHello()

    val multiply = {x:Int, y:Int -> x*y}
    multiply(2,4)
}