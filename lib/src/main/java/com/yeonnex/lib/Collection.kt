package com.yeonnex.lib

// kotlin collection
// List, Set, Map

// List

fun main(args: Array<String>){
    listCollection()
    setCollection()

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

