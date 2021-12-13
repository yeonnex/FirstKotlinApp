package com.yeonnex.lib

// 코틀린 클래스 상속과 서브 클래스
// 코틀린의 모든 클래스는 기본적으로 Any 라는 클래스의 파생(상속) 클래스가 된다
// Any 클래스는 모든 클래스의 기반이 되는 속성과 함수를 제공한다
// 코틀린은 다중 상속을 지원하지 않는다
// 바로 위 계층의 부모 클래스는 하나만 될 수 있다

// 서브 클래스 생성
// 클래스 상속 관련 코드의 오류나 착오 방지를 위해 부모 클래스에 open 키워드 사용


// 하나 이상의 보조 생성자를 갖는 클래스의 경우
//  서브 클래스 선언에서도 보조 생성자를 구현하고
//  super 키워드를 사용해서 부모 클래스의 보조 생성자를 호출

open class ParentClass{
    var x: Int = 0
    constructor(num: Int){
        x = num
    }
}
class Subclass : ParentClass{
    constructor(num: Int) : super(num){
        // 서브 클래스 생성자에서 실행할 코드
    }
}

// 부모(상위) 클래스
open class BankAccountP{
    var accountNumber: Int = 0
    var accountBalance: Double = 0.0
    constructor(number:Int, balance: Double){
       accountNumber = number
       accountBalance = balance
    }
}
// 서브 클래스 기능 확장.
class SavingAccount : BankAccountP{
    constructor(number: Int, balance: Double): super(number, balance)

    // 이자율과 이자금액 산출함수
    var rate: Double = 0.02
    fun calculateInterest(): Double{
        // 이 클래스에는 accountBalance가 없지만, 상속받았기 때문에 이 변수 사용 가능하다
        // 코드 상속 받은 것임. 기존것 + 알파 근데, 인터페이스 상속을 더 권함. 사이드이펙트때문에
        return rate * accountBalance
    }
}

fun main(args:Array<String>){
    val sc = Subclass(0)
    println(sc.x)
    sc.x = 100
    println(sc.x)

    val sa = SavingAccount(12345, 1000.0)
    println(sa.calculateInterest())
}