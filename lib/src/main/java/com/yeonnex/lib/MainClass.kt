package com.yeonnex.lib

public class MainClass {
    public fun printTest(){
        println("test")
    }
}

// JVM : 코틀린 소스코드 -> 바이트코드로 변환 -> JVM이 바이트 코드 실행 -> 콘솔출력
// 데이터타입 : 자바는 (기본 데이터타입 8개 + 참조 데이터타입), 코틀린은 모두 참조 데이터타입
// 코틀린 내장(built-in)타입 : String, Char, Boolean, Int, Double, 과 컬렉션 타입 List, Set, Map
// 연산자(우선순위)
// 메소드(함수)
// =====================
// 객체지향(추상화, 캡슐화, 상속, 다형성) -> 리팩토링 + 디자인 패턴
// 쓰레드, IO, 네트워크
//  LIBRARY : swing, JavaFX(Win), Spring(Web), Android(mobile)

// 코틀린 REPL : 작은 코드를 테스트해보고 싶을 때 사용
// Tools > Kotlin > Kotlin REPL
// 실행 : Ctrl + Enter

// REPL은 한 줄 단위로 코드를 실행할 때는 편리하지만 긴 코드는 불편하다.
// 스크래치 파일을 사용하면 긴 코드도 쉽게 테스트 가능!
// File > New > Scratch File
fun main(args: Array<String>){
    example12()
//    example11()
//    example10()
//    example09()
//    example08()
//    example07()
//    example06()
//    example05()
//    example00()
}

// 코틀린은 정적 타입 프로그래밍 언어: 일단 변수의 타입이 선언되면 이후에는 다르 타입의 데이터를 저장할 수 없다
// 타입 변환 type casting(as)
// 안전 타입 변환(as?)
// 타입 검사 type check(is)
private fun example12(){
    val keyMgr = MainClass() as MainClass
    val keyMgr2 = MainClass() as? MainClass
    if (keyMgr is MainClass){
        println("keyMgr is MainClass")
    }
}
// 늦은 초기화 lateinit
// lateinit 변수가 초기화되었는지 확인하려면 해당 변수의 isInitialized 속성을 검사
private fun example11(){
    lateinit var myName: String

//    if(::myName.isInitalized){ // 초기화 검사. 아직 지원이 안되고 있음. 문법상으로는 있음
//        // 코드
//    }
}
private fun example00() {
    println(1 + 2)
    println(1 + 2)
    println(1 + 2)
}

private fun example05() {
    val userCount: Int = 10 // Int 타입 어노테이션 지정.
    val silsu = 2.231 // 생략하면 자동으로 타입추론됨. Double 로 타입 추론이 일어남
    val companyName = "yeonnex" // String 타입 추론

    // 타입 어노테이션을 지정하여 불변 변수를 선언할 때는 나중에 지정이 가능
    val bookTitle: String // 선언만 했음. 나중에 초기화 가능
    val iosBookType = false
    if (iosBookType) {
        bookTitle = "iOS App"
    } else {
        bookTitle = "Android App"
    }
    println(bookTitle)
    // bookTitle = "iOS App" Error
}

// null 불가능 타입에 null 가능 타입을 넣으면 컴파일 에러
// null 여부 확인 필요
private fun example06(){
    // val userName: String = null // 에러남 기본적으로 코틀린은 null 값이 못들어오게 함

    val userName: String? = "Hello"
//    println(userName.length) // 이렇게도 사용할 수 없음

    // 코틀린은 방어적인 코드를 문법적으로 쓸 수 있게끔 강제함
    if (userName != null){
        println(userName.length) // 이렇게 사용해주어야 함!
    }
}

// null 가능 변수는 함수 호출이나 참조 시에도 보통 방법으로 사용할 수 없다
// null 이 아니라는 것을 함수 호출 전에 검사하는 코드가 필요
// 또는 안전호출 연산자(?)를 사용
private fun example08() {
    var username: String? = null
    val length = username?.length
}

// Not-null assertion !!
// null 가능 타입의 모든 제약을 받지 않으나 런타임 시에 null 포인터 예외 발생 가능
private fun example07() {
    var username: String? = null
    val length = username!!.length
}

// 엘비스 연산자 (?:) : null값을 검사하는 if-else 문
private fun example10(){
    val myname: String = "Hello"
    if(myname != null){
        println(myname)
    }else{
        println("String is null")
    }

    println(myname ?: "String is null") // 코틀린스러운 코드, 위 if-else 문을 짧게 표현 가능하게
    // 근데 이렇게 짜지는 말자.. 그냥 읽을수만 있게끔
}
// null 가능 타입과 let 함수
// null 가능 타입의 객체에 대해 호출하면 null 가능 타입을 it 라는 null  불가능 변수로 변환
private fun example09(){
    val firstNumber = 10
    val secondNumber: Int? = 20

    // val result = firstNumber.times(secondNumber) 컴파일에러
    // 널 가능한 변수는 항상 체크를 먼저 해주어야 함
    if (secondNumber != null){
        val result = firstNumber.times(secondNumber)

        // val result = firstNumber.times(it)
        println(result)

    }
    // 또는 이렇게
    secondNumber?.let{
        val result = firstNumber.times(it)
        println(result)
    }

    // 널포인터 익셉션을 방지하기 위해, 즉 안전한 코드를 위해 문법적으로 이렇게 null
    // 값을 신경써줌. 이게 자바와의 큰 차이
}
