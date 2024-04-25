package com.example.tictacgame

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.example.tictacgame.databinding.ActivitySignInPage2Binding
import com.google.firebase.auth.FirebaseAuth

class Sign_in_page : AppCompatActivity() {
    private  val binding:ActivitySignInPage2Binding by lazy {
        ActivitySignInPage2Binding.inflate(layoutInflater)
    }
    private lateinit var auth: FirebaseAuth
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(binding.root)

        binding.login.setOnClickListener {
            startActivity(Intent(this,Log_in_page::class.java))
            finish()
        }
          auth= FirebaseAuth.getInstance()

        binding.registerButton.setOnClickListener {
            val email=binding.username.text.toString()
            val name=binding.name.text.toString()
            val password=binding.password.text.toString()
            val repassword=binding.repeatePassword.text.toString()

            if (email.isEmpty()||name.isEmpty()||password.isEmpty()||repassword.isEmpty()){
                Toast.makeText(this , "Please fill the all dealtes", Toast.LENGTH_SHORT).show()
            }else if (password != repassword){
                Toast.makeText(this, "Repeat password Must be same", Toast.LENGTH_SHORT).show()
            }else
                auth.createUserWithEmailAndPassword(email,password)
                    .addOnCompleteListener (this){task ->
                        if (task .isSuccessful){
                            Toast.makeText(this, "Regester is successful", Toast.LENGTH_SHORT).show()
                            startActivity(Intent(this,Log_in_page::class.java))
                            finish()
                        }
                        else{
                            Toast.makeText(this, "register is failed :${task.exception?.message}", Toast.LENGTH_SHORT).show()
                        }

                    }
        }
    }
}