package dev.ujjwal.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import dev.ujjwal.globofly.R
import kotlinx.android.synthetic.main.activity_welcome.*


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        // To be replaced by retrofit code
        message.text = "Black Friday! Get 50% cash back on saving your first spot."
    }

    fun getStarted(view: View) {
        val intent = Intent(this, DestinationListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
