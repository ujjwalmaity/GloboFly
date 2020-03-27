package dev.ujjwal.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.ujjwal.globofly.R
import dev.ujjwal.globofly.helpers.DestinationAdapter
import dev.ujjwal.globofly.helpers.SampleData
import dev.ujjwal.globofly.models.Destination
import dev.ujjwal.globofly.services.DestinationService
import dev.ujjwal.globofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_destiny_list.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class DestinationListActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_destiny_list)

        setSupportActionBar(toolbar)
        toolbar.title = title

        fab.setOnClickListener {
            val intent = Intent(this@DestinationListActivity, DestinationCreateActivity::class.java)
            startActivity(intent)
        }
    }

    override fun onResume() {
        super.onResume()

        loadDestinations()
    }

    private fun loadDestinations() {
        val destinationService = ServiceBuilder.buildService(DestinationService::class.java)

        val requestCall = destinationService.getDestinationList(null)
        //val requestCall = destinationService.getDestinationList("India")

        requestCall.enqueue(object : Callback<List<Destination>> {

            override fun onFailure(call: Call<List<Destination>>, t: Throwable) {
                // Network error OR Establishing connection with server
                // Error creating http request OR Error processing http response
                Toast.makeText(this@DestinationListActivity, "Error occurred $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Destination>>, response: Response<List<Destination>>) {
                if (response.isSuccessful) {
                    // Your status code is in the range of 200 to 299
                    val destinationList = response.body()!!
                    destiny_recycler_view.adapter = DestinationAdapter(destinationList)
                } else if (response.code() == 401) {
                    Toast.makeText(this@DestinationListActivity, "Your session has expire. Please Login again.", Toast.LENGTH_SHORT).show()
                } else {
                    // Application-level failure
                    // Your status code is in the range of 300's, 400's and 500's
                    Toast.makeText(this@DestinationListActivity, "Failed to retrieve items", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }
}
