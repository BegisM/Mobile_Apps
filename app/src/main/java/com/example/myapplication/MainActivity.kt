package com.example.myapplication

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import com.example.myapplication.R
import android.widget.Button

class MainActivity : AppCompatActivity() {

    private var isFragmentAVisible = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Set initial fragment
        replaceFragment(FragmentA())

        // Find the button using findViewById
        val switchButton = findViewById<Button>(R.id.switchButton)
        switchButton.setOnClickListener {
            val nextFragment: Fragment = if (isFragmentAVisible) FragmentB() else FragmentA()
            replaceFragment(nextFragment)
            isFragmentAVisible = !isFragmentAVisible
        }
    }

    private fun replaceFragment(fragment: Fragment) {
        supportFragmentManager.beginTransaction()
            .replace(R.id.fragment_container, fragment)
            .commit()
    }
}
