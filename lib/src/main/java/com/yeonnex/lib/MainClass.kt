package com.yeonnex.lib

class MainClass {

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

fun main(args: Array<String>){
    example08()
//    example07()
//    example06()
//    example05()
//    example00()
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
