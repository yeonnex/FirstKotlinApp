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
    open fun displayBalance(){
        println("$accountBalance")
    }
}
// 서브 클래스 기능 확장.
// 상속 받은 함수 오버라이딩
//  상속 받은 함수의 새로운 버전을 작성:
//  함수 시그내쳐(함수명, 매개변수 및 타입, 반환타입) 은 동일하게 하면서 함수 몸체의 실행 코드만 다르게 작성
//
class SavingAccount : BankAccountP{
    constructor(number: Int, balance: Double): super(number, balance)
    constructor(number: Int, balance: Double, rate: Double): super(number, balance){
        this.rate = rate
    }

    // 이자율과 이자금액 산출함수
    var rate: Double = 0.02
    fun calculateInterest(): Double{
        // 이 클래스에는 accountBalance가 없지만, 상속받았기 때문에 이 변수 사용 가능하다
        // 코드 상속 받은 것임. 기존것 + 알파 근데, 인터페이스 상속을 더 권함. 사이드이펙트때문에
        return rate * accountBalance
    }

    override fun displayBalance(){
        super.displayBalance() // 부모 클래스의 함수 실행
        println("Interest rate is $rate")
    }
}

fun main(args:Array<String>){
    val sc = Subclass(0)
    println(sc.x)
    sc.x = 100
    println(sc.x)

    val sa = SavingAccount(12345, 1000.0)
    println(sa.calculateInterest())

    val sa2 = SavingAccount(12345, 100.0, 0.07)
    println(sa2.calculateInterest())
}