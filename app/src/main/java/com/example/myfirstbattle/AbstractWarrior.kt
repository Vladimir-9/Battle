package com.example.myfirstbattle

import kotlin.random.Random

abstract class AbstractWarrior(
    maxHealthLevel: Int,
    override var chanceAvoidHit: Int,
    private val accuracy: Int,
    private val weapon: AbstractWeapon
) : Warrior {

    override var isKilled: Boolean = false   // переопределенная булевая переменная, не мертв ли солдат
    var currentHealth = maxHealthLevel        // присваиваем начальное здоровье, переменной текущее здоровье

    override fun attack(warrior: Warrior) {

        var attackDamage = 0         // сюда суммируем урон
        if (weapon.isEmptyCartridges) {     // если магазин пустой , то перезаряжаем
            weapon.recharge()
        } else {                  // если нет пустой магазин, то атакуем
            weapon.getCartridges().forEach {
                if (accuracy * Random.nextInt(10) > warrior.chanceAvoidHit * Random.nextInt(10)) {  // проверяем вероятнось, попасть у нападающего и уклонится от удара у врага
                    attackDamage += it.getTheCurrentDamage()          // считаем урон и присваиваем переменной
                }
            }
            warrior.takeDamage(attackDamage)         // наносим урон врагу
        }
    }

    override fun takeDamage(damage: Int) {   // метод понести урон
        if (!isKilled) {     // если не мертв то вычитается здоровье
            currentHealth -= damage
        }
        if (currentHealth <= 0) {  // если здровье меньше критического
            currentHealth = 0
            isKilled = true      //  то присваиваем булевой переменной = ТРУ
        }
    }
}