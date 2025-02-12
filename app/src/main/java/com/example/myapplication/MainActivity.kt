package com.example.myapplication

import android.os.Bundle
import android.renderscript.ScriptGroup.Binding
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.example.myapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var Binding:ActivityMainBinding
    private lateinit var ViewModel:MainActivityViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        Binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        ViewModel=ViewModelProvider(this).get(MainActivityViewModel::class.java)
        Binding.toolbar.title="Kabaddi Kounter"
        Binding.apply {
            txtScore.setText(ViewModel.GetScoreTeam1().toString())
            btn1.setOnClickListener {
                ViewModel.UpdateScoreTeam1(1)
                WhoWin()
                txtScore.setText(ViewModel.GetScoreTeam1().toString())
            }
            btn2.setOnClickListener {
                ViewModel.UpdateScoreTeam1(2)
                WhoWin()
                txtScore.setText(ViewModel.GetScoreTeam1().toString())
            }
            btnReset.setOnClickListener {
                ViewModel.resetScore(0)
                txtScore.setText(ViewModel.GetScoreTeam1().toString())
                txtScore2.setText(ViewModel.GetScoreTeam2().toString())
                txtWin.text=""
            }
        }
        Binding.apply {
            txtScore2.setText(ViewModel.GetScoreTeam2().toString())
            btn12.setOnClickListener {
                ViewModel.UpdateScoreTeam2(1)
                WhoWin2()
                txtScore2.setText(ViewModel.GetScoreTeam2().toString())
            }
            btn22.setOnClickListener {
                ViewModel.UpdateScoreTeam2(2)
                WhoWin2()
                txtScore2.setText(ViewModel.GetScoreTeam2().toString())
            }

        }

        }
    private fun WhoWin(){
        val totalScoreTeam1=ViewModel.GetScoreTeam1()
        if(totalScoreTeam1>=15){
            Binding.txtWin.text="Team 1 Win!"
        }
            }

    private fun WhoWin2(){
        val totalScoreTeam2=ViewModel.GetScoreTeam2()
        if(totalScoreTeam2>=15){
            Binding.txtWin.text="Team 2 Win!"
        }
    }
}