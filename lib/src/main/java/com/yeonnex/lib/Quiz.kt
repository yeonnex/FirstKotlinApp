package com.yeonnex.lib

fun main(args: Array<String>){
    println("quizzes")
    println("윤년 맞추기..")
    println(checkLeapYear(1700)) // 1700 x
}
fun checkLeapYear(year: Int): String{
    val answer:String
    if (year % 4 == 0 && year%100==0 && year%400==0) answer="o"
    else if (year % 4 == 0 && year%100==0) answer = "x"
    else if (year % 4 == 0) answer="o"
    else answer="x"
    return "$year $answer"
}