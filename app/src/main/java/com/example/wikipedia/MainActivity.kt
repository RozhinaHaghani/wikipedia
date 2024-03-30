package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.example.wikipedia.databinding.ActivityMainBinding
import com.example.wikipedia.fragments.FragmentExplore
import com.example.wikipedia.fragments.FragmentProfile
import com.example.wikipedia.fragments.FragmentTrend


class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)

        setContentView(binding.root)

        setSupportActionBar(findViewById(R.id.toolbarMain))

        val actionBarDrawerToggle = ActionBarDrawerToggle(
            this,
            binding.drawerLayoutMain,
            binding.toolbarMain,
            R.string.navigation_open_drawer,
            R.string.navigation_close_drawer
        )

        binding.drawerLayoutMain.addDrawerListener(actionBarDrawerToggle)

        actionBarDrawerToggle.syncState()   //for that icon for opening the navigation drawer...its not a regular icon..it has animation on it.
        //but we van set a regular icon with no animation too
        binding.navigationView.setNavigationItemSelectedListener {   //for accessing the menu's items.

            when (it.itemId) {

                R.id.item_writer -> {

                    Toast.makeText(this, "on be a writer clicked", Toast.LENGTH_SHORT).show()
                    binding.drawerLayoutMain.closeDrawer(GravityCompat.START)

                }

                R.id.item_photographer -> {

                }

                R.id.item_movieMaker -> {

                }

                R.id.item_translator -> {

                }

                R.id.item_wikipedic -> {

                }

                R.id.item_wikipedio -> {

                }
            }



            true      //in the method's parameters it has it: it means it should return a value..so we return true and the end of this..search more about it.

        }

        addFirstFragment(FragmentExplore())

        binding.buttonNavigationMain.setOnItemSelectedListener {

            when (it.itemId) {

                R.id.explore_item -> {

                    replaceFragment(FragmentExplore())

                }

                R.id.trend_item -> {

                    replaceFragment(FragmentTrend())

                }

                R.id.profile_item -> {

                    replaceFragment(FragmentProfile())

                }

            }



            true
        }

        binding.buttonNavigationMain.setOnItemReselectedListener() {}      //hamintor khali sedash mizanim
        //ye mozoee ke dar buttom navigation ha hast ine ke vaghti ro ye itemesh click
        //mishe va ye fragment baz mishe, agar dobare ro hamun f click she dobare az
        //aval load mikone chiz mizaye dakhele f ro..baraye inke in etefagh nayofte
        //in tabe setonitemreselected ro sedash mizanim va migim vaghti call shod
        //yani vaghti itemi reselect shod hich kari nakon(load nakon dobare)
    }

    private fun replaceFragment(fragment: Fragment) {

        val transaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.frame_main_container, fragment)
        transaction.addToBackStack(null)
        transaction.commit()
    }

    private fun addFirstFragment(fragment: Fragment) {
        replaceFragment(FragmentExplore())
        binding.buttonNavigationMain.selectedItemId = R.id.explore_item
    }
}