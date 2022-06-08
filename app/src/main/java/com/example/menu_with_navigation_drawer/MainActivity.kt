package com.example.menu_with_navigation_drawer

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.databinding.DataBindingUtil
import com.example.menu_with_navigation_drawer.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    lateinit var toggle:ActionBarDrawerToggle
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= DataBindingUtil.setContentView(this,R.layout.activity_main)

        toggle= ActionBarDrawerToggle(this,binding.drawerlayout,R.string.open,R.string.close)
        binding.drawerlayout.addDrawerListener(toggle)
        toggle.syncState()

        supportActionBar?.setDisplayHomeAsUpEnabled(true)  //this will help navigation drawer to change icon from arrow to other three line icon

        binding.navview.setNavigationItemSelectedListener {
            when(it.itemId)
            {
                R.id.item1 -> Toast.makeText(this,"ITEM 1 SELECTED",Toast.LENGTH_SHORT).show()
                R.id.item2 -> Toast.makeText(this,"ITEM 2 SELECTED",Toast.LENGTH_SHORT).show()
                R.id.item3 -> Toast.makeText(this,"ITEM 3 SELECTED",Toast.LENGTH_SHORT).show()
                R.id.item4 -> Toast.makeText(this,"ITEM 4 SELECTED",Toast.LENGTH_SHORT).show()
            }
             true
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item))
        {
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}