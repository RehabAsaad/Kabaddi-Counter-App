package com.example.myapplication

import androidx.lifecycle.ViewModel

class MainActivityViewModel: ViewModel() {
    private var scoreTeam1=0
    fun GetScoreTeam1():Int {
        return scoreTeam1
    }
    fun UpdateScoreTeam1(score:Int){
        scoreTeam1+=score
    }
    fun resetScore(score:Int){
        scoreTeam1=score
        scoreTeam2=score
    }
    private var scoreTeam2=0
    fun GetScoreTeam2():Int {
        return scoreTeam2
    }
    fun UpdateScoreTeam2(score:Int){
        scoreTeam2+=score
    }

}