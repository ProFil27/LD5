package com.example.ld5

import android.os.Bundle
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity(), ListFragment.OnItemSelectedListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }
    }

    // Pasirinkus įrašą, parenkame 2 arba 3 fragmentą ir įdedame į backStack
    override fun onItemSelected(text: String) {
        val hasA = text.any { it.equals('a', ignoreCase = true) }
        val fragment = if (hasA) ACountFragment.newInstance(text) else StatsFragment.newInstance(text)

        supportFragmentManager.beginTransaction()
            .replace(R.id.detail_container, fragment)
            .addToBackStack(null)
            .commit()
    }
}
