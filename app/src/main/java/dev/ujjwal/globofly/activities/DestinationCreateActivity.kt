package dev.ujjwal.globofly.activities

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.ujjwal.globofly.R
import dev.ujjwal.globofly.helpers.SampleData
import dev.ujjwal.globofly.models.Destination
import dev.ujjwal.globofly.services.DestinationService
import dev.ujjwal.globofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_destiny_create.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DestinationCreateActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_create)

        setSupportActionBar(toolbar)
        // Show the Up button in the action bar.
        supportActionBar?.setDisplayHomeAsUpEnabled(true)

        btn_add.setOnClickListener {
            val newDestination = Destination()
            newDestination.city = et_city.text.toString()
            newDestination.description = et_description.text.toString()
            newDestination.country = et_country.text.toString()

            val destinationService = ServiceBuilder.buildService(DestinationService::class.java)

            val requestCall = destinationService.addDestination(newDestination)

            requestCall.enqueue(object : Callback<Destination> {
                override fun onFailure(call: Call<Destination>, t: Throwable) {
                    Toast.makeText(this@DestinationCreateActivity, "Error occurred $t", Toast.LENGTH_SHORT).show()
                }

                override fun onResponse(call: Call<Destination>, response: Response<Destination>) {
                    if (response.isSuccessful) {
                        val newlyCreatedDestination = response.body()
                        finish()
                        Toast.makeText(this@DestinationCreateActivity, "Successfully added", Toast.LENGTH_SHORT).show()
                    } else {
                        Toast.makeText(this@DestinationCreateActivity, "Failed to retrieve items", Toast.LENGTH_SHORT).show()
                    }
                }
            })
        }
    }
}
