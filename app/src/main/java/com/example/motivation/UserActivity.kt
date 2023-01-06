package com.example.motivation

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.preference.PreferenceManager
import android.widget.Toast
import com.example.motivation.databinding.ActivityUserBinding

class UserActivity : AppCompatActivity() {
    private lateinit var binding: ActivityUserBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityUserBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        var myPreferences: SharedPreferences = PreferenceManager.getDefaultSharedPreferences(this)
        var myEditor: SharedPreferences.Editor = myPreferences.edit()

        var username = myPreferences.getString("USER_NAME", "")

        if (username != "") {
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

        binding.btnAvancar.setOnClickListener {
            var name = binding.editUser.text.toString()
            myEditor.putString("USER_NAME", "$name")
            myEditor.apply()
            startActivity(Intent(this, MainActivity::class.java))
            finish()
        }

    }

}
