package com.example.myfirstbattle

sealed class FireType(val count: Int) {

    object ShootingSingle : FireType(1)
    object ShootingInQueue : FireType(5)

}

