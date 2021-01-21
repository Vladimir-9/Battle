package com.example.myfirstbattle

fun main() {
    val war = readLine()?.toInt()?.let { Battle(it,it) }

    if (war != null) {
        while (!war.isBattleOver) {
            war.battle()
            println(war.getBattleStatus())
        }
    }
}