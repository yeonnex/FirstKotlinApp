package com.yeonnex.lib

fun main(args: Array<String>){
    println("quizzes")
    println("윤년 맞추기..")
//    println(checkLeapYear(1700)) // 1700 x
    game369()
}
fun checkLeapYear(year: Int): String{
    val answer:String
    if (year % 4 == 0 && year%100==0 && year%400==0) answer="o"
    else if (year % 4 == 0 && year%100==0) answer = "x"
    else if (year % 4 == 0) answer="o"
    else answer="x"
    return "$year $answer"
}

fun game369(){
    for (cnt in 0..99){
        var a = cnt / 10 // 10의 자리
        var b = cnt % 10 // 1의 자리
        print("" + a + b)
        if (a % 3 == 0 && a!=0) print("*")// 10의 자리 3,6,9 비교
        if (b % 3 == 0 && b != 0) print("*") // 1의 자리 3,6,9 비교
        println()
    }
}