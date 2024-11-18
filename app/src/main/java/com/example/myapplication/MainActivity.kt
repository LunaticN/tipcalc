package com.example.myapplication

import android.opengl.ETC1
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    private lateinit var subtotalEditText: EditText
    private lateinit var tipPercentSeekBar: SeekBar
    private lateinit var tipPercentSeekBarProgressTextView: TextView
    private lateinit var tipQualityTextView: TextView
    private lateinit var tipTextView: TextView
    private lateinit var grandTotalTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subtotalEditText = findViewById(R.id.subtotal)
        tipPercentSeekBar = findViewById(R.id.tipPercentSb)
        tipPercentSeekBarProgressTextView = findViewById(R.id.tipPercentSbProgress)
        tipQualityTextView = findViewById(R.id.tipQuality)
        tipTextView = findViewById(R.id.tip)
        grandTotalTextView = findViewById(R.id.grandTotal)


        var subtotalNum = 0
        subtotalEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
                TODO("Not yet implemented")
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                TODO("Not yet implemented")
            }

            override fun afterTextChanged(s: Editable?) {
                subtotalNum = Integer.parseInt(subtotalEditText.text.toString())
            }
        })

        var tipPercentNum = 0
        tipPercentSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                TODO("Not yet implemented")
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
                TODO("Not yet implemented")
                //get progress of seek bar here
            }
        })
    }

    private fun calculateTip(subtotal: Int, tipPercent: Int): Double{
        return (subtotal * (tipPercent * 0.01))
    }

}