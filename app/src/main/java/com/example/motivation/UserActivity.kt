package com.example.motivation

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.btnAvancar.setOnClickListener {
            validation()
        }

    }

    fun validation(){
        var name = binding.editUser.text.toString()
        if (name != "") {

            SecurityPreferences(this).storeString("USER_NAME", name)

            startActivity(Intent(this, MainActivity::class.java))
            finish()
        } else {
            Toast.makeText(this, R.string.validation, Toast.LENGTH_SHORT).show()
        }
    }
}