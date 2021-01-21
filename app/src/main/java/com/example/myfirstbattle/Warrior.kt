package com.example.myfirstbattle

interface Warrior {
    var isKilled: Boolean
    var chanceAvoidHit: Int
    fun attack(warrior: Warrior)
    fun takeDamage(damage: Int)
}