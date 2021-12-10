package com.yeonnex.lib
// 자바에서는 클래스 == 파일이었는데 코틀린은 그렇지 않음
fun main(args: Array<String>){
    println("Operator")
    // example00()
    // example01()
    example03()
}

// private 으로 설정함으로써 이 파일 내에서만 쓸 수있도록
// public 으로 하면 외부 파일에서도 쓸 수 있는데, 이름 중복되니까,,

// 연산자 우선순위
private fun example00(){
    val num1 = 456
    val result1 = num1 / 10 * 10 + 1
    val result2 = num1 - (num1 % 10 -1)
    println("$result1, $result2")
}

// 대입 연산자 : 표현식의 결과를 변수에 저장
private fun example01(){
    val num:Int // 변수 선언
    num = 0 // 변수 초기화

    val num2 = 2 // 변수 선언과 초기화

    val d = 0.1234
    val e = 1234E-4
    println(d+e)
}

// ===, !== 객체 비교

// 범위 연산자
private fun example03(){
    for ( i in 1..10 ){
        println("i = $i")
    }
}

// 비트 연산자 : 비트 단위의 값을 처리 - 0과 1단위
// 비트 변환 inv()
// 비트 AND and()
// 비트 XOR xor() : 두 비트가 다르면 1, 같으면 0
// 비트 왼쪽/오른쪽 이동 shl(), shr()
// 2의 배수 단위로 프로그램을 많이 하는 이유가, 속도에도 큰 영향을 주기 때문.
// 그냥 곱하기 2하는 것보다, 비트연산으로 왼쪽으로 한 칸 옮겨주는 것이 훠얼씬 빠르다
private fun example04(){
    var x = 0
    var y = 3
    var z = y.inv()
    println(z) // -4

    x = 171
    y = 3
    z = x.and(y) // 3
    println(z)

    z = x.or(y) // 171
    z = x.xor(y) // 168
}