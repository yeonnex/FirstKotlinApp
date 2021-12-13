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
// 기본 생성자 primary constructor :
//  class BankAccount (val accountNumber: Int, var accountBalance: Double) {}
//  기본적인 초기화 작업을 수행, 클래스의 헤더에 선언, 클래스의 기본 생성자는 하나만 가질 수 있다
//  기본 생성자에 선언된 변수는 자동으로 클래스 속성이 된다

// 초기화 블록 initializer block
//  기본 생성자는 실행코드를 포함할 수 없으므로
//  기본 생성자 다음에 자동 실행
//  (단, 기본 생성자가 없고 보조 생성자만 있을 때는 실행되지 않는다)

// 클래스 커스텀 접근자
//  속성 기본 접근자 : 속성값을 가져오거나 설정하는 기본 제공 접근자
//  속성 커스텀 접근자 : 속성이 반환되거나 설정되기 전에 원하는 로직을 실행
//      각 속성에 getter 나 setter 를 작성하여 구현
//      setter 를 선언하면 속성값을 변경한다는 것이므로 해당 속성을 val이 아닌 var 로 선언해야함
class BankAccount (val accountNumber: Int, var accountBalance: Double) { // 기본 생성자를 쓰면, 속성으로 안만들어도 되기 때문에 코드가 좀 심플해지긴 함
    init {
        // 기본 생성자를 썼었을 때, 초기화하는 블록
    }
    var lastName: String = "" // 고객이름
    val fees: Double = 25.00

    var balanceLessFees: Double
        get() { return accountBalance - fees}
        set(value) {accountBalance = value - fees}

    constructor(number: Int, balance: Double, name: String) : this(number, balance){ // 기본 생성자 호출!
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

    account1.accountBalance = 1000.0
    val balance = account1.accountBalance
    account1.displayBalance()

    account1.balanceLessFees = 200.0
    account1.displayBalance()

}