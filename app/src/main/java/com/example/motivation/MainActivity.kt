package com.example.motivation

import android.content.Context
import android.media.Image
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.View.OnClickListener
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import com.example.motivation.databinding.ActivityMainBinding
import com.example.motivation.fragments.BodyFragment
import org.w3c.dom.Text

class MainActivity : AppCompatActivity(), View.OnClickListener {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()

        binding.imgAll.setOnClickListener(this)
        binding.imgHappy.setOnClickListener(this)
        binding.imgSunny.setOnClickListener(this)
    }

    override fun onClick(view: View) {
        if(view.id in listOf(binding.imgAll.id, binding.imgHappy.id, binding.imgSunny.id)){
            filter(view.id)
        }
    }

    private fun filter(id: Int){
        binding.imgAll.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imgHappy.setColorFilter(ContextCompat.getColor(this, R.color.black))
        binding.imgSunny.setColorFilter(ContextCompat.getColor(this, R.color.black))

        when (id) {
            binding.imgAll.id -> {
                binding.imgAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
            binding.imgHappy.id -> {
                binding.imgHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
            binding.imgSunny.id -> {
                binding.imgSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
            }
        }
    }

}
