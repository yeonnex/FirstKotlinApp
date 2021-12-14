package com.yeonnex.lib

// 클래스 생성
// Person, Point2D, Student

// Person
//  속성 name 문자열
//  기본 생성자 구현
//  인스턴스 생성, name 본인 이름
//  인스턴스 속성 호출, name 값 출력

class Person (val name:String) {

}

open class Point2D(var x: Int, var y: Int) {

    // 커스텀 접근이 가능한 속성 info
    open val info: String
        get() {return "Point2D $x , $y"}
}

class Student(val name:String, val course:String){
    // 속성 커스텀 접근자 구현 info -> name, course 출력문자열 반환
    val info: String
        get(){return "student name : $name, course : $course"}
}

fun main(args:Array<String>){
    val person1 = Person("seoyeon")
    println(person1.name)
    val Point2D1 = Point2D(20,30)
    println(Point2D1.info)
    val student1: Student =  Student("seoyeon","안드로이드")
    println(student1.info)
}