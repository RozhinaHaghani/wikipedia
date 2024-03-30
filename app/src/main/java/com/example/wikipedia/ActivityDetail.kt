package com.example.wikipedia

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.core.content.ContextCompat
import com.example.wikipedia.databinding.ActivityDetailBinding

class ActivityDetail : AppCompatActivity() {
    private lateinit var binding: ActivityDetailBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        //for put the name of our app(wikipedia) on the toolbar:
        setSupportActionBar(binding.toolbarDetail)

        //for making the title of "wikipedia" invisible when our toolbar is expanded:
        //we set the unseen color for "wikipedia"
        binding.collapsingDetail.setExpandedTitleColor(
            ContextCompat.getColor(this, android.R.color.transparent)
        )

        //for put "back" button(Home button) in out toolbar:
        //for this case we have to call setSupportActionBar again, but because we called that above, we call supportActionBar that access us the setSupportActionBar
        //we have to call to methods on supportActionBar:
        //those !! are for make idea sure that we set the toolbar and that is not null..if we don't put them we get error
        supportActionBar!!.setHomeButtonEnabled(true)
        supportActionBar!!.setDisplayHomeAsUpEnabled(true)
        //now we have our Home button but the problem is it doesn't work, because we have to override onOptionsItemSelected function
        //onOptionItemSelected function is the specific onclicklistener for our option menu(all the buttons like home button,menu,..in toolbar)
        //for overriding a function we write it outside the onCreate function
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        //deleted the return statement because we don't want to call the father function too
        //but we have to return a boolean to it so we return true otherwise we get an error
        //like our button navigation that we sat when for each buttoms, we set a if statement..why if? because here we have only one option menu(home button)
        //the id of home button is always this:

        if (item.itemId == android.R.id.home) {
            onBackPressedDispatcher.onBackPressed()
        }
        return true


    }
}
