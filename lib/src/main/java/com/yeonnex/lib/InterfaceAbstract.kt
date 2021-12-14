package com.yeonnex.lib

// 코틀린 인터페이스와 추상클래스
// 개요
//  인터페이스 interface : 여러 클래스들의 공통적인 속성과 행동을 나타낼 수 있다
//  클래스는 어떻게 how 구현하는가에 초점을 두지만 인터페이스는 무엇 what을 구현해야 하는지 나타냄
//  추상클래스 absract class : 인터페이스와 클래스의 특성을 혼합한 클래스 타입
//  최근 현대적인 프로그래밍에서는 추상 클래스보다 인터페이스를 더 많이 씀
//  보통 인터페이스만 쓴다고 생각하면 됨. 추상클래스는 써야할 때만

open class Ant {
    var name = "Ant"

    override fun toString():String{ // 무조건 코틀린에서 모든 클래스는 Any라는 클래스를 상속 받음. 이 클래스는 이미 toString 이라는 함수르 ㄹ가지고 있음
        return "이름: $name"
    }
    open fun place(): String{
        return "$name 는 동굴에서 산다"
    }
}

class WaterAnt : Ant(){ // 기본 생성자 호출!
    override fun place():String{
        return "$name 은 water에서 산다"
    }
    fun show(): String{
        return "water 주변"
    }
}

fun main(args: Array<String>){
    val ant: Ant = Ant()
    println(ant.toString())
    println(ant.place())

    val want: WaterAnt = WaterAnt()
    println(want.toString())
    println(want.place())
    println(want.show())
}