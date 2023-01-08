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
import androidx.navigation.NavController
import androidx.navigation.fragment.NavHostFragment
import com.example.motivation.data.Frase
import com.example.motivation.databinding.ActivityMainBinding


class MainActivity : AppCompatActivity(), View.OnClickListener {

        private lateinit var binding: ActivityMainBinding
        private lateinit var navController: NavController
        private var categoryId = 1


        override fun onCreate(savedInstanceState: Bundle?) {
            super.onCreate(savedInstanceState)
            binding = ActivityMainBinding.inflate(layoutInflater)
            setContentView(binding.root)
            supportActionBar?.hide()

            binding.imgAll.setOnClickListener(this)
            binding.imgHappy.setOnClickListener(this)
            binding.imgSunny.setOnClickListener(this)

            val navHostFragment = supportFragmentManager.findFragmentById(binding.fragmentContainerBody.id) as NavHostFragment
            navController = navHostFragment.navController

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


        var frases = listOf(
            Frase("Frase 1", 1),
            Frase("Frase 2", 1),
            Frase("Frase 3", 2),
            Frase("Frase 4", 2),
            Frase("Frase 5", 3),
            Frase("Frase 6", 3)
        )

        when (id) {

            binding.imgAll.id -> {
                binding.imgAll.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 1
                for (item in frases) {
                    var id = item.categoryId
                    var listaRandomizada = frases.random()
                    if(listaRandomizada.categoryId == categoryId){
                        findViewById<TextView>(R.id.textViewMotivation).text =
                            listaRandomizada.description }
                }
            }
            binding.imgHappy.id -> {
                binding.imgHappy.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 2
                for (item in frases) {
                    var listaRandomizada = frases.random()
                    if(listaRandomizada.categoryId == categoryId){
                        findViewById<TextView>(R.id.textViewMotivation).text =
                            listaRandomizada.description }
                    }
                }


            binding.imgSunny.id -> {
                binding.imgSunny.setColorFilter(ContextCompat.getColor(this, R.color.white))
                categoryId = 3
                for (item in frases) {
                    var id = item.categoryId
                    var listaRandomizada = frases.random()
                    if(listaRandomizada.categoryId == categoryId){
                        findViewById<TextView>(R.id.textViewMotivation).text =
                            listaRandomizada.description }
                }
                }
            }
        }

    }
