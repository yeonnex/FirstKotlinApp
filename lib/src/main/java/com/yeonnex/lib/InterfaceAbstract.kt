package com.yeonnex.lib

// 코틀린 인터페이스와 추상클래스
// 개요
//  인터페이스 interface : 여러 클래스들의 공통적인 속성과 행동을 나타낼 수 있다
//  클래스는 어떻게 how 구현하는가에 초점을 두지만 인터페이스는 무엇 what을 구현해야 하는지 나타냄
//  추상클래스 absract class : 인터페이스와 클래스의 특성을 혼합한 클래스 타입
//  최근 현대적인 프로그래밍에서는 추상 클래스보다 인터페이스를 더 많이 씀
//  보통 인터페이스만 쓴다고 생각하면 됨. 추상클래스는 써야할 때만

// 인터페이스 정의와 구현
//  interface 키워드를 사용
//  속성은 선언만 하고 초기화하는 코드가 없고,
//  함수는 헤더만 선언하고 구현이 없는 추상함수를 사용(시그내쳐만)
//  open 을 굳이 명시적으로 안붙여도 됨!
//  인스턴스를 생성할 수 없다
interface IAnt {
    var name: String
    fun place(): String
    fun show(): String
}

// 추상 클래스 정의와 구현
//  abstract 키워드를 class 키워드 앞에 사용
//  코드에 순서가 필요할 때 씀
//  그렇지 않은 경우, 인터페이스를 씀

open class Ant : IAnt { // IAnt에서 정의된 것들은, 무조건 Ant 에서 implement 해주어야 한다. 구현을 강제화할 수 있음
    override var name = "Ant"

    override fun toString():String{ // 무조건 코틀린에서 모든 클래스는 Any라는 클래스를 상속 받음. 이 클래스는 이미 toString 이라는 함수르 ㄹ가지고 있음
        return "이름: $name"
    }
    override fun place(): String{
        return "$name 는 동굴에서 산다"
    }

    override fun show(): String {
        return ""
    }

}

class WaterAnt : Ant(){ // 기본 생성자 호출!
    override fun place():String{
        return "$name 은 water에서 산다"
    }
    override fun show(): String{
        return "water 주변"
    }
}
class FireAnt(override var name: String) : IAnt{
    override fun place(): String {
        return name + "는 산에서 산다."
    }

    override fun show(): String {
        return "산 주변"
    }

}
fun main(args: Array<String>){
    displayAnt(Ant()) // 깔-끔

    val want: WaterAnt = WaterAnt()
    println(want.toString())
    println(want.place())
    println(want.show())

    val fant: FireAnt = FireAnt("fant")
    val ifant: IAnt = FireAnt("fant") // 이것도 됨!
    println(fant.toString()) // 재정의를 해주지 않았기 때문에 Any 클래스대로 나옴
    println(fant.place())
    println(fant.show())
}

fun displayAnt(ant: IAnt){
    println( ant.toString())
    println( ant.place())
    println( ant.show())
}