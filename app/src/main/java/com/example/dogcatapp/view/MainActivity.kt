package com.example.dogcatapp.view

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.dogcatapp.databinding.ActivityMainBinding;
import com.example.dogcatapp.utils.MyPreferences
import com.example.dogcatapp.R

class MainActivity : AppCompatActivity(), View.OnClickListener {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        if (MyPreferences(this).getString("username") != ""){
            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }

        binding.keepBtn.setOnClickListener(this)

    }

    override fun onClick(view: View) {
        if (view.id == R.id.keep_btn){
            val sp = MyPreferences(this)
            sp.setString("username", binding.usernameEt.text.toString())

            startActivity(Intent(this, HomeActivity::class.java))
            finish()
        }
    }
}