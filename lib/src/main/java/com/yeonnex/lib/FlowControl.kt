package com.yeonnex.lib

fun main(args:Array<String>){
    println("FlowControl")
    // example01()
    example04()
}
private fun example01(){
    for (index in 1..5){
        println(index)
    }
    for (index in "Hello") print("$index.."); println()
    for (index in 100 downTo 90 ) print("$index.."); println() // downTo 는 큰수에서 작은수
    for (index in 1 until 10 ) print("$index.."); println() // 10은 포함 안됨
    for (index in 1 until 100 step 10 ) print("$index.."); println() // 10은 포함 안됨
    // until 은 포함이 안됨!
}

private fun example02() {
    var cnt = 0
    while (cnt < 10) {
        print("$cnt..")
        cnt++ // 증감 연산자는 맨 마지막에 해주는 게 좋음. 오해가 없음
    }
    println()
}

private fun example03(){
    var cnt = 10
    do{
        cnt--;
        print("$cnt..")
    }while (cnt>0)
    println()

    cnt = 10
    do print("${--cnt}..") while (cnt > 0);println() // {} 안에 표현식을 쓸 수 있다
}

// 루프 벗어나기
// break : 현재 루프를 벗어나서 루프 바로 다음에 있는 코드를 실행
// continue : 루프 내부의 나머지 코드는 실행하지 않고 루프의 처음으로 돌아가서 다음 반복을 계속 실행
// 라벨링@ 을 사용해서 표현식 앞에 라벨을 붙이고 break와 continue 문에서 참조
// break@라벨링

private fun example04(){
    var cnt = 10
    for (i in 0..20){
        cnt++
        if (cnt > 20){
            break
            print("$cnt..")
        }
    }
    println()

    // 근데 레이블은 잘 쓰지 않음. 보통 함수로 처리
    outerloop@
    for (i in 1..100){
        println("i -> $i")
        for (j in 1..100){
            print("$j.. ")
            if (j == 10) break@outerloop
        }
    }
}

private fun example05(){
    val x = 10
    val y = if (x>9) x else 9
}