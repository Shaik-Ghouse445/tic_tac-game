package com.example.tictacgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import com.example.tictacgame.databinding.LogInPageBinding
import com.google.firebase.Firebase
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Log_in_page : AppCompatActivity() {
    private  val binding: LogInPageBinding by lazy {
        LogInPageBinding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth

    override fun onStart() {
        super.onStart()
        val currentuser:FirebaseUser?= auth.currentUser
        if (currentuser != null){
            startActivity(Intent(this,MainActivity::class.java))
            finish()
        }
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)


        binding.signButton.setOnClickListener {
            startActivity(Intent(this,Sign_in_page::class.java))
            finish()
        }

        auth=FirebaseAuth.getInstance()

        binding.login.setOnClickListener {
            val username=binding.username.text.toString()
            val password=binding.password.text.toString()

            if (username.isEmpty()||password.isEmpty()){
                Toast.makeText(this, "Please fill the all dealtes", Toast.LENGTH_SHORT).show()
            }else{
                 auth.signInWithEmailAndPassword(username,password)
                     .addOnCompleteListener { task ->
                         if (task .isSuccessful){
                             Toast.makeText(this, "sign is successfull", Toast.LENGTH_SHORT).show()
                             startActivity(Intent(this,MainActivity::class.java))
                             finish()
                         }
                           else{
                             Toast.makeText(this, "sign is failed:${task.exception?.message}", Toast.LENGTH_SHORT).show()
                         }
                     }
            }
        }


    }
}