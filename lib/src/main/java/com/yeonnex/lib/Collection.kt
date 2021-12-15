package com.yeonnex.lib

// kotlin collection
// List, Set, Map


fun main(args: Array<String>){
    // listCollection()
    // setCollection()
    mapCollection()

}

// Map
// key 와 이 키에 대응되는 값 value 의 쌍으로 저장
fun mapCollection(){
    val map = mapOf("one" to 1.0, "two" to 2.0, "three" to 3.0) // 읽기 전용 Map 생성
    val a = mapOf(Pair("one",1.0), Pair("two", 2.0), Pair("three", 3.0))

    val mmap = mutableMapOf("one" to 1.0, "two" to 2.0, "three" to 3.0) // 변경 가능 Map
    println(mmap["one"])
    println(mmap.getValue("one"))
    println(mmap.getOrElse("1"){"No search"})
    println(mmap.getOrDefault("1", 0))

    mmap += "four" to 4.0; println(mmap)
    mmap += "four" to 5.0; println(mmap) // 중복된 키는 값 업데이트
    mmap -= "four"; println(mmap)
    mmap["1"] = 1.0; // add와 같은 기능. 추가됨
    mmap.put("2", 2.0); println(mmap) // 이렇게도 쓸 수 있지만 위의 방법이 가장 간결함
    mmap.putAll(listOf("3" to 3.0, "4" to 4.0)); println(mmap)

    // 반복 처리
    mmap.forEach{ (k,v) -> print("$k=$v..")}; println()

    // 키가 없으면 항목을 추가하고, 있으면 기존 값을 반환
    println(mmap.getOrPut("5"){5.0}); println(mmap)
    println(mmap.getOrPut("5"){10.0}); println(mmap) // 업데이트가 되지 않음...!

    // 지정한 키의 항목을 제외한 새로운 Map을 반환
    val b = mmap - "5"
    println(b); println(mmap) // 새로운 b map생성 , 원본 mmap은 그대로
    mmap.clear()

}

private fun listCollection() {
    val list: List<String> = listOf("one", "two", "three") // read-only List
    println(list)
    println(list[0])
    println(list.first())
    println(list.last())
    println(list.getOrElse(4) { "Unknown" }) // access not existing index. "SAFE" index usage function
    println(list.getOrNull(3) ?: "Unknown")
    println(list.contains("one")) // check if element exists
    println(
        list.containsAll(
            listOf(
                "one",
                "four"
            )
        )
    ) // check if multi-element exists. Only true when all exists

    val mlist = mutableListOf("one", "two", "three") // not only read, but also write
    println(mlist.remove("one")) // return true if working well
    mlist.add("four"); println(mlist)
    mlist.add(0, "one")
    mlist[0] = "1"; println(mlist)
    mlist.addAll(listOf("Eli", "Alex"))
    mlist -= listOf("Eli", "Alex")

    // Lambda
    mlist.removeIf { it.contains("o") }; println(mlist)
    val readOnlyList = mlist.toList() // change to "read-only"
    mlist.clear(); println(mlist)

    // iterator
    for (p in list) print("$p.."); println()
    list.forEach { p -> print("$p..") }; println() // using lambda
    list.forEachIndexed { index, p -> println("$index= $p..") }

    // shuffle element
    print("shuffled : ")
    println(list.shuffled().first())

    // destructure
    val (a, b, c) = list
    println("$a $b $c")
    val (d, _, e) = list // can use "_" if don't want destructure
}

fun setCollection(){
    val set = setOf("one", "two", "three") // 읽기 전용 Set
    println(set.contains("one"))
    // println(set[2]) set 이라 안됨
    println(set.elementAt(2))

    val mset = mutableSetOf("one", "two", "three")
    mset.add("4"); println(mset)

    // 반복 처리
    for (p in set) print("$p.."); println()

    mset.clear()

    // List -> Set
    println(listOf("one", "two", "two").toSet())

    // List -> Set -> List
    println(listOf("one", "two", "two").toSet().toList())

}

