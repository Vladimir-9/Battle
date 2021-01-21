package com.example.myfirstbattle

import kotlin.random.Random

class Team(private val amountWarrior: Int) {

    val teamWarrior: MutableList<AbstractWarrior> = mutableListOf()

    init {
        addWarrior()
    }

    private fun addWarrior() {
        var probability: Int

        for (i in 0 until amountWarrior) {
            probability = Random.nextInt(1, 100)
            when (probability) {
                in 95 .. 100 -> {
                    teamWarrior.add(WarriorColonel())
                }
                in 80 .. 95 -> {
                    teamWarrior.add(WarriorMajor())
                }
                in 50 .. 80 -> {
                    teamWarrior.add(WarriorCaptain())
                }
                in 1 .. 50 -> {
                    teamWarrior.add(WarriorLieutenant())
                }
            }
        }
    }
}