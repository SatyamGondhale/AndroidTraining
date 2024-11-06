package com.sanjivani.optionsmenudemo

import android.content.Context
import android.content.Intent
import android.content.SharedPreferences
import android.content.SharedPreferences.Editor
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import com.sanjivani.optionsmenudemo.api.ApiClient
import com.sanjivani.optionsmenudemo.model.Post
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var myPreferences: SharedPreferences
    lateinit var username: EditText
    lateinit var password: EditText
    lateinit var submitButton: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        username = findViewById(R.id.username)
        password = findViewById(R.id.password)
        submitButton = findViewById(R.id.button)
        myPreferences = this.getSharedPreferences("account_details", Context.MODE_PRIVATE)
        val apiService = ApiClient.getApiService()
        apiService.getPostsList()
        apiService.getPostsList().enqueue(object : Callback<MutableList<Post>> {
            override fun onResponse(p0: Call<MutableList<Post>>, p1: Response<MutableList<Post>>) {
                if (p1.isSuccessful) {
                    val listOfData  = p1.body()
                }

            }

            override fun onFailure(p0: Call<MutableList<Post>>, p1: Throwable) {
                Log.i("EXCEPTION", p1.stackTrace.toString())
            }

        })
        if (myPreferences.getString("pasword", "").equals("Welcome@123")) {
            val myintent = Intent(this, HomeScreen::class.java)
            startActivity(myintent)

            //myPreferences.edit().remove()
        }
        submitButton.setOnClickListener {
            val editor = myPreferences.edit()
            editor.putString("username", username.text.toString())
            editor.putString("pasword", password.text.toString())
            editor.apply()
            Toast.makeText(this, "Account Created", Toast.LENGTH_SHORT).show()
            username.setText("")
            password.setText("")
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.optionsmenu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.addAccount -> {
                Log.i("MAIN_ACTIVITY", "Add account was clicked")
            }

            R.id.addIcon -> {

            }

            R.id.addLocation -> {

            }

            R.id.addTask -> {

            }
        }
        return true
    }
}