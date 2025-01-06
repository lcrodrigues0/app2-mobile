package com.example.dogcatapp.view

import android.content.res.ColorStateList
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.core.content.ContextCompat
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import com.example.dogcatapp.R
import com.example.dogcatapp.databinding.ActivityHomeBinding
import com.example.dogcatapp.utils.MyPreferences
import com.example.dogcatapp.viewModel.HomeViewModel
import kotlin.random.Random

class HomeActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityHomeBinding
    private lateinit var homeVM: HomeViewModel

    private var isDogSelected: Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.greetingsTv.text = getString(R.string.greetings, MyPreferences(this).getString("username"))

        homeVM = ViewModelProvider(this)[HomeViewModel::class.java]
        homeVM.setCurrentAnimal("dog")
        setObserver()

        binding.dogBtn.setOnClickListener(this)
        binding.catBtn.setOnClickListener(this)
        binding.generateBtn.setOnClickListener(this)

    }

    fun setObserver(){
        homeVM.getCurrentAnimal().observe(this, Observer {
            binding.sentenceTv.text = homeVM.getCurrentSentence()
        })
    }

    override fun onClick(view: View) {
        if(view.id == R.id.cat_btn && isDogSelected){
            isDogSelected = false
            binding.catBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.yellow))
            binding.dogBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))

            homeVM.setCurrentAnimal("cat")

        } else if(view.id == R.id.dog_btn && !isDogSelected){
            isDogSelected = true
            binding.dogBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.yellow))
            binding.catBtn.imageTintList = ColorStateList.valueOf(ContextCompat.getColor(this, R.color.white))

            homeVM.setCurrentAnimal("dog")

        } else if(view.id == R.id.generate_btn){
            if(isDogSelected)
                homeVM.setCurrentAnimal("dog")
            else
                homeVM.setCurrentAnimal("cat")
        }
    }
}