package com.yeonnex.lib

// 코틀린 클래스 상속과 서브 클래스
// 코틀린의 모든 클래스는 기본적으로 Any 라는 클래스의 파생(상속) 클래스가 된다
// Any 클래스는 모든 클래스의 기반이 되는 속성과 함수를 제공한다
// 코틀린은 다중 상속을 지원하지 않는다
// 바로 위 계층의 부모 클래스는 하나만 될 수 있다

// 서브 클래스 생성
// 클래스 상속 관련 코드의 오류나 착오 방지를 위해 부모 클래스에 open 키워드 사용

open class ParentClass{
    var x: Int = 0
}
class Subclass : ParentClass(){

}

fun main(args:Array<String>){
    val sc = Subclass()
    println(sc.x)
    sc.x = 100
    println(sc.x)
}