package com.yeonnex.lib

fun main(args: Array<String>){
    println("Function & Lambda")
    example02()
}



// 단일 표현식 함수 : 함수 실행 코드에 하나의 표현식만 있을 때
fun multiply(x: Int, y:Int) :Int = x*y

// 람다식: 독립적인 코드블록
// {<매개변수명>: <매개변수타입>, ... -><값을 반환하는 표현식>}
private fun example00() {
    val sayHello = {println("Hello")}
    sayHello()

    val multiply = {x:Int, y:Int -> x*y} // multiply 에는 람다함수가 대입되는 게 아니라, 람다함수의 참조가 저장됨
    multiply(2,4)
}

fun buildMessageFor(name: String, count: Int): String {
    return ("$name, you are customer number $count")
}

// 람다식처럼 일반 함수의 참조를 변수에 저장하고자 할 때
// 함수 이름앞에 두 개의 콜론(::)을 붙이고 함수 괄호를 뺴면 된다
private fun example01(){
    val buildMsg = ::buildMessageFor // 기존에 만들었던 함수
    val msg = buildMsg("park", 5)
}


private fun example02(){
    val result = {x:Int, y:Int -> x*y}(10,20)
    val nextMsg = {println("hello"); "Goodbye"}()
    println(nextMsg)
}

// 고차함수
private fun example09(){
    fun inchesToFeet(inches:Double): Double{
        return inches * 0.0833333
    }
    fun inchesToYard(inches: Double):Double{
        return inches * 0.0277778
    }
    fun outputConversion(converterFunc: (Double)->Double, value:Double){
        val result = converterFunc(value)
        println("$result")
    }
    outputConversion(::inchesToFeet, 22.45)
    outputConversion(::inchesToYard, 22.45)

    fun decideFunc(feet: Boolean): (Double) -> Double{
        if(feet){
            return ::inchesToFeet
        }else{
            return ::inchesToYard
        }
    }
}