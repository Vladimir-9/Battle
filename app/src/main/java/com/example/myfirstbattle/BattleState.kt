package com.example.myfirstbattle

sealed class BattleState {
    abstract val message: String
    override fun toString(): String {
        return message
    }

    class BattleProgress(teamOneHealth: Int, teamTwoHealth: Int) : BattleState() {
        override var message = "Progress (teamOneHealth = $teamOneHealth - teamTwoHealth = $teamTwoHealth)"
    }

    object TeamOneWon : BattleState() {
        override var message = "The first team won"
    }

    object TeamTwoWon : BattleState() {
        override var message = "The second team won"
    }

    object Draw : BattleState() {
        override var message = "Draw"
    }
}