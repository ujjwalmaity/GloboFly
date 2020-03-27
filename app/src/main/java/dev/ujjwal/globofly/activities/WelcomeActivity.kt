package dev.ujjwal.globofly.activities

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.ujjwal.globofly.R
import dev.ujjwal.globofly.services.MessageService
import dev.ujjwal.globofly.services.ServiceBuilder
import kotlinx.android.synthetic.main.activity_welcome.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class WelcomeActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_welcome)

        val messageService = ServiceBuilder.buildService(MessageService::class.java)

        val requestCall = messageService.getMessages("http://192.168.43.222:8000/messages")

        requestCall.enqueue(object : Callback<String> {
            override fun onFailure(call: Call<String>, t: Throwable) {
                Toast.makeText(this@WelcomeActivity, "Error occurred $t", Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<String>, response: Response<String>) {
                if (response.isSuccessful) {
                    val msg: String? = response.body()
                    msg?.let {
                        message.text = msg
                    }
                } else {
                    Toast.makeText(this@WelcomeActivity, "Failed to retrieve items", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    fun getStarted(view: View) {
        val intent = Intent(this, DestinationListActivity::class.java)
        startActivity(intent)
        finish()
    }
}
