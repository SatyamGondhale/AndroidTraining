package com.sanjivani.optionsmenudemo

import android.content.DialogInterface
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.ListView
import androidx.appcompat.app.AlertDialog
import androidx.appcompat.app.AppCompatActivity



class HomeScreen : AppCompatActivity() {
    lateinit var listView: ListView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home_screen)
        listView = findViewById(R.id.myList)

        val temporaryData = listOf<String>("One", "two", "three", "four", "five", "six")
        val adapter = ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, temporaryData)
        listView.adapter = adapter
        listView.onItemClickListener = object : AdapterView.OnItemClickListener {
            override fun onItemClick(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Log.i("LIST_VIEW_CLICK", temporaryData[position].toString())
                /* val mySnackbar = Snackbar.make(listView,"Message is Deleted", Snackbar.LENGTH_SHORT)
                 mySnackbar.setAction("Undo",{
                     Log.i("CLICK","Undo Was Click")
                 })
                 mySnackbar.show()*/
                val alertDialog = AlertDialog.Builder(this@HomeScreen).setTitle("Delete Alert")
                    .setMessage("Are you sure to delete item ?")
                    .setPositiveButton("Yes", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            TODO("Not yet implemented")
                        }
                    }).setNegativeButton("No", object : DialogInterface.OnClickListener {
                        override fun onClick(dialog: DialogInterface?, which: Int) {
                            TODO("Not yet implemented")
                        }

                    })
                alertDialog.show()
            }
        }
    }

}
