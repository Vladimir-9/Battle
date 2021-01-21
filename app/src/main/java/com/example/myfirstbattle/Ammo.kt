package com.example.myfirstbattle

import kotlin.random.Random

enum class Ammo(
    private val damage: Int,
    private val chanceOfCriticalDamage: Int,
    private val coefficientCriticalDamage: Int
) {

    CONVENTIONAL_CARTRIDGE(damage = 10, chanceOfCriticalDamage = 1, coefficientCriticalDamage = 5),
    BREACHING_CARTRIDGE(damage = 50, chanceOfCriticalDamage = 2, coefficientCriticalDamage = 3),
    ARMOR_PIERCING_CARTRIDGE(
        damage = 80,
        chanceOfCriticalDamage = 3,
        coefficientCriticalDamage = 2
    );


    fun getTheCurrentDamage(): Int {           // метод расчета урона
        return if (chanceOfCriticalDamage >= Random.nextInt(10)) { // Проверка вероятности критического урона
            damage * coefficientCriticalDamage               // Расчет критического урона
        } else damage
    }

}