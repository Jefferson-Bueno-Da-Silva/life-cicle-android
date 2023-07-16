package com.example.lifecicleadroidessential

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.result.ActivityResultLauncher
import androidx.activity.result.contract.ActivityResultContracts.StartActivityForResult

class MainActivity : AppCompatActivity() {
    // para mandar e receber dados de uma activity aberta
    private lateinit var resultLauncher: ActivityResultLauncher<Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        Log.i("LOG", "onCreate() MainActivity " + System.currentTimeMillis())

        resultLauncher = registerForActivityResult(StartActivityForResult()) { result ->
            if (result.resultCode == Activity.RESULT_OK) {
                result.data?.apply {
                    Toast
                        .makeText(
                            this@MainActivity,
                            getStringExtra("RETURN"),
                            Toast.LENGTH_SHORT
                        )
                        .show()
                }
            }
        }
    }

    override fun onStart() {
        super.onStart()

        Log.i("LOG", "onStart() MainActivity " + System.currentTimeMillis())
    }

    override fun onResume() {
        super.onResume()

        Log.i("LOG", "onResume() MainActivity " + System.currentTimeMillis())
        val button = findViewById<Button>(R.id.button)
        button.setOnClickListener {
            val editText = findViewById<EditText>(R.id.editText)
            val intent = Intent(this, SecondActivity::class.java)
            intent.putExtra("TEXT_VALUE", editText.text.toString())
            resultLauncher.launch(intent)
        }
    }

    override fun onPause() {
        super.onPause()

        Log.i("LOG", "onPause() MainActivity")
    }

    override fun onStop() {
        super.onStop()


        Log.i("LOG", "onStop() MainActivity")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("LOG", "onDestroy() MainActivity")
    }
}