package com.example.tictacgame

import android.content.Intent
import android.nfc.Tag
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.ImageButton
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tictacgame.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private  val binding: ActivityMainBinding by lazy {
        ActivityMainBinding.inflate(layoutInflater)
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)
    }

    fun clickable (view: View){
        val buttonselected=view as ImageButton
        var celld=0
        when (buttonselected.id){
            R.id.imageButton1 -> celld = 1
            R.id.imageButton2 -> celld = 2
            R.id.imageButton3 -> celld = 3
            R.id.imageButton5 -> celld = 4
            R.id.imageButton6 -> celld = 5
            R.id.imageButton7 -> celld = 6
            R.id.imageButton8 -> celld = 7
            R.id.imageButton9 -> celld = 8
            R.id.imageButton11 -> celld = 9
        }
        play(celld,buttonselected)
        winner()
        resetgame()
    }

    private fun resetgame() {
         binding.resetbutton.setOnClickListener {
             recreate()
         }
    }

    private fun winner() {
        var winner = 0
        // for first row
        if (player1.contains(1) && player1.contains(2) && player1.contains(3)){
            winner=1
        }
        // for second row
        if (player1.contains(4) && player1.contains(5) && player1.contains(6)){
            winner=1
        }
        // for third row
        if (player1.contains(7) && player1.contains(8) && player1.contains(9)){
            winner=1
        }
        // for first column
        if (player1.contains(1) && player1.contains(4) && player1.contains(7)){
            winner=1
        }
        // for second column
        if (player1.contains(2) && player1.contains(5) && player1.contains(8)){
            winner=1
        }
        // for third column
        if (player1.contains(3) && player1.contains(6) && player1.contains(9)){
            winner=1
        }

        // for first row
        if (player2.contains(1) && player2.contains(2) && player2.contains(3)){
            winner=2
        }
        // for second row
        if (player2.contains(4) && player2.contains(5) && player2.contains(6)){
            winner=2
        }
        // for third row
        if (player2.contains(7) && player2.contains(8) && player2.contains(9)){
            winner=2
        }
        // for first column
        if (player2.contains(1) && player2.contains(4) && player2.contains(7)){
            winner=2
        }
        // for second column
        if (player2.contains(2) && player2.contains(5) && player2.contains(8)){
            winner=2
        }
        // for third column
        if (player2.contains(3) && player2.contains(6) && player2.contains(9)){
            winner=2
        }

        // for first row
        if (player1.contains(1) && player1.contains(5) && player1.contains(9)){
            winner=1
        }
        // for second row
        if (player1.contains(7) && player1.contains(5) && player1.contains(3)){
            winner=1
        }
        // for second column
        if (player2.contains(1) && player2.contains(5) && player2.contains(9)){
            winner=2
        }
        // for third column
        if (player2.contains(7) && player2.contains(5) && player2.contains(3)){
            winner=2
        }
        if (winner == 1){
            Toast.makeText(this, "Player 1 win", Toast.LENGTH_SHORT).show()
        }else if (winner == 2){
            Toast.makeText(this , "player 2 win ", Toast.LENGTH_SHORT).show()

        }
    }

    var currentpalyer=1
    var player1 =ArrayList<Int>()
    var player2 =ArrayList<Int>()
    private fun play(celld: Int, buttonselected: ImageButton) {
           if(currentpalyer == 1){

               buttonselected.setBackgroundResource(R.drawable.o)
               player1.add(celld)
               currentpalyer = 2
           }else{
               buttonselected.setBackgroundResource(R.drawable.x)
               player2.add(celld)
               currentpalyer = 1
           }
    }
}