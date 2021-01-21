package com.example.myfirstbattle

abstract class AbstractWeapon(
    private val maxNumberCartridgesMagazine: Int,
    private val fireType: FireType
) {
    private val listOfCartridges: MutableList<Ammo> = mutableListOf()
    var isEmptyCartridges: Boolean = true

    abstract fun creatingCartridge(): Ammo   // абстрактный метод создания патрона

    fun recharge(value: Int = maxNumberCartridgesMagazine) {      // метод перезарядки, принимает в параметр максимальное количество патронов

        val newListOfCartridges: MutableList<Ammo> = mutableListOf()   // создаем новый список

        while (newListOfCartridges.size < value) {     // заполняем новый список патронами
            newListOfCartridges.add(creatingCartridge()) // заполняем новый список патронами
        }
        listOfCartridges.addAll(newListOfCartridges)     // передаем новый заполненный список патронов, в старый пустой список
        isEmptyCartridges = false   // говорим что магазин полный

    }

    fun getCartridges(): MutableList<Ammo> {
        val list = mutableListOf<Ammo>()
        for (i in 0 until fireType.count) {
            if (listOfCartridges.isEmpty()) {
                break
            }
            list.add(listOfCartridges.removeAt(0))

        }
        if (listOfCartridges.isEmpty()) {
            isEmptyCartridges = true
        }
        return list
    }

    object Weapons {
        val submachineGun = object : AbstractWeapon(15, FireType.ShootingInQueue) { // автомат
            override fun creatingCartridge(): Ammo {
                return Ammo.BREACHING_CARTRIDGE
            }
        }
        val pistol = object : AbstractWeapon(10, FireType.ShootingSingle) {  // пистолет
            override fun creatingCartridge(): Ammo {
                return Ammo.CONVENTIONAL_CARTRIDGE
            }
        }
        val shotGun = object : AbstractWeapon(5, FireType.ShootingSingle) {  // дробовик
            override fun creatingCartridge(): Ammo {
                return Ammo.ARMOR_PIERCING_CARTRIDGE
            }
        }
        val machineGun = object : AbstractWeapon(30, FireType.ShootingInQueue) {  // пулемет
            override fun creatingCartridge(): Ammo {
                return Ammo.BREACHING_CARTRIDGE
            }
        }
    }
}
