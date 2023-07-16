package com.example.lifecicleadroidessential

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import com.example.lifecicleadroidessential.databinding.ActivitySecondBinding

class SecondActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

    }

    override fun onResume() {
        super.onResume()

        Log.i("LOG", "onResume() SecondActivity")
        val editText = findViewById<EditText>(R.id.editTextText)
        val button2 = findViewById<Button>(R.id.button2)

        button2.setOnClickListener {
            val data = Intent()
            data.putExtra("RETURN", editText.text.toString())
            setResult(RESULT_OK, data)
            finish()
        }
    }

    override fun onStart() {
        super.onStart()

        val textView = findViewById<TextView>(R.id.textView)
        textView.text = intent.getStringExtra("TEXT_VALUE")

        Log.i("LOG", "onStart() SecondActivity")
    }

    override fun onDestroy() {
        super.onDestroy()

        Log.i("LOG", "onDestroy() SecondActivity")
    }
}