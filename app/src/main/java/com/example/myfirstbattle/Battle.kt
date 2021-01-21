package com.example.myfirstbattle

import kotlin.random.Random

class Battle(
    countTeamOne: Int,
    countTeamTwo: Int
) {
    private val teamOne = Team(countTeamOne)            // первая команда
    private val teamTwo = Team(countTeamTwo)            // вторая команда
    var isBattleOver = false

    fun getBattleStatus(): BattleState {    // получение состояния битвы
        val teamOneHealth = teamOne.teamWarrior.sumBy { it.currentHealth }
        val teamTwoHealth = teamTwo.teamWarrior.sumBy { it.currentHealth }


        if (teamOneHealth == 0 && teamTwoHealth == 0) {
            isBattleOver = true
            return BattleState.Draw
        } else if (teamTwoHealth == 0) {
            isBattleOver = true
            return BattleState.TeamOneWon
        } else if (teamOneHealth == 0) {
            isBattleOver = true
            return BattleState.TeamTwoWon
        }

        return BattleState.BattleProgress(teamOneHealth, teamTwoHealth)
    }

    fun battle() {
        teamOne.teamWarrior.shuffled()      // перемешиваем воинов первой команды
        teamTwo.teamWarrior.shuffled()      // перемешиваем воинов второй команды

        var count = 0
        while (count < teamOne.teamWarrior.size) {

            val warriorTeamOne = teamOne.teamWarrior[Random.nextInt(0, teamOne.teamWarrior.size)]
            val warriorTeamTwo = teamTwo.teamWarrior[Random.nextInt(0, teamTwo.teamWarrior.size)]

            if (!teamOne.teamWarrior[count].isKilled && !warriorTeamTwo.isKilled) {
                teamOne.teamWarrior[count].attack(warriorTeamTwo)
            }
            if (!teamTwo.teamWarrior[count].isKilled && !warriorTeamOne.isKilled) {
                teamTwo.teamWarrior[count].attack(warriorTeamOne)
            }
            count++
        }
    }
}