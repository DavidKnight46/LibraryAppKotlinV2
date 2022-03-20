package com.example.libraryserviceandroidv2.libraryservice.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import androidx.navigation.ui.setupActionBarWithNavController
import com.example.libraryserviceandroidv2.EditActivity
import com.example.libraryserviceandroidv2.R
import com.example.libraryserviceandroidv2.ViewActivity
import com.example.libraryserviceandroidv2.databinding.ActivityViewBinding
import com.google.android.material.snackbar.Snackbar

class viewActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityViewBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.toolbar)

        val navController = findNavController(R.id.nav_host_fragment_content_view)
        appBarConfiguration = AppBarConfiguration(navController.graph)
        setupActionBarWithNavController(navController, appBarConfiguration)

        binding.fab.setOnClickListener { view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_view)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }

    fun onAddClick(view: View){
        var intent = Intent(this, AddActivity::class.java)

        startActivity(intent)
    }

    fun onEditCLick(view: View){
        var intent = Intent(this, EditActivity::class.java)

        startActivity(intent)
    }

    fun onViewCLick(view: View){
        var intent = Intent(this, ViewActivity::class.java)

        startActivity(intent)
    }
}