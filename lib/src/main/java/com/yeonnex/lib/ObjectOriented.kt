package com.yeonnex.lib

// 객체 object
// 객체는 클래스의 인스턴스라고도 하며 독립적인 기능을 갖는 모듈
// 자신의 데이터를 갖는 속성과 특정 작업을 수행하는 역할 - 메서드(함수)로 구성

// 클래스 class
// 클래스는 생성되는 객체가 어떤 모습인지, 속성과 메서드를 정의
// class 클래스명 : 부모 클래스명 { //속성 // 함수 }
// 클래스의 속성 추가
// 데이터 캡슐화 : encapsulation : 클래스에 캡슐화된 데이터를 속성 또는 인스턴스 변수라고 한다
// 클래스에 함수 정의
// 코틀린의 표준 함수 선언 문법을 사용해서 클래스의 열고 닫는 중괄호{} 내부에 선언

// 클래스의 기본과 보조 생성자
//  생성자 constructor : 클래스 인스턴스를 생성할 때 초기화 작업을 해야 하는 경우
// 보조생성자 secondary constructor :
//  class BankAccount { constructor(...) {초기화 코드}

class BankAccount {
    var accountBalance: Double = 0.0 // 잔액
    var accountNumber: Int = 0 // 계좌 번호
    var lastName: String = "" // 고객이름
    constructor(number: Int, balance: Double){
        // 이름이 다르니 this를 명시적으로 써도 되고 안써도 됨
        this.accountNumber = number
        accountBalance = balance
    }
    constructor(number: Int, balance: Double, name: String){ // 생성자를 여러 개 만들 수 있음
        this.accountNumber = number
        accountBalance = balance
        lastName = name
    }
    // 게좌 잔액을 출력하는 함수
    fun displayBalance(){
        println("Number $accountNumber")
        println("Current balance is $accountBalance")
    }
}

// 클래스 인스턴스 생성하고 초기화
// 클래스로 뭔가를 하려면 인스턴스를 생성, 생성되는 인스턴스의 참조를 저장할 변수를 선언
// val account1 = BankAccount() // 변수의 타입을 코틀린 컴파일러가 추론, 생략 가능
// 클래스 인스턴스가 생성되어 변수를 사용(참조)할 수 있다
fun main(args:Array<String>){
    val account1:BankAccount = BankAccount(12345, 100.0)
    val account2 = BankAccount(12346,100.0,"jang")
    account1.displayBalance()
}