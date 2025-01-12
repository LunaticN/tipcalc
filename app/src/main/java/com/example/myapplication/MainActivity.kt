package com.example.myapplication

import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.widget.EditText
import android.widget.SeekBar
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    private lateinit var subtotalEditText: EditText
    private lateinit var tipPercentSeekBar: SeekBar
    private lateinit var tipPercentSeekBarProgressTextView: TextView
    private lateinit var tipQualityTextView: TextView
    private lateinit var tipAmtTextView: TextView
    private lateinit var grandTotalAmtTextView: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        subtotalEditText = findViewById(R.id.subtotalEt)
        tipPercentSeekBar = findViewById(R.id.tipPercentSb)
        tipPercentSeekBarProgressTextView = findViewById(R.id.tipPercentSbProgress)
        tipQualityTextView = findViewById(R.id.tipQuality)
        tipAmtTextView = findViewById(R.id.tipAmt)
        grandTotalAmtTextView = findViewById(R.id.grandTotalAmt)

        tipPercentSeekBar.progress = 20
        tipQualityTextView.text = "good"
        tipQualityTextView.setTextColor(getColor(R.color.good))

        var subtotalNum = 0.0
        var tipPercentNum = 0
        tipPercentSeekBar.setOnSeekBarChangeListener(object: SeekBar.OnSeekBarChangeListener {
            override fun onProgressChanged(seekBar: SeekBar?, progress: Int, fromUser: Boolean) {
                tipPercentNum = tipPercentSeekBar.progress
                tipPercentSeekBarProgressTextView.text = tipPercentSeekBar.progress.toString()
                fullCalc(tipPercentNum, subtotalNum)
            }

            override fun onStartTrackingTouch(seekBar: SeekBar?) {
            }

            override fun onStopTrackingTouch(seekBar: SeekBar?) {
            }
        })

        subtotalEditText.addTextChangedListener(object: TextWatcher {
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
            }

            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                subtotalNum = subtotalEditText.text.toString().toDouble()
                fullCalc(tipPercentNum, subtotalNum)
            }

            override fun afterTextChanged(s: Editable?) {
            }
        })

    }

    private fun calculateGrandTotal(subtotal: Double, tipPercent: Int): Double{
        return (subtotal * ((tipPercent * 0.01) + 1))
    }

    private fun calculateOnlyTip(subtotal: Double, tipPercent: Int): Double{
        return (subtotal * (tipPercent * 0.01))
    }

    private fun tipQuality(tipPercent: Int){
        if (tipPercent >= 26) {
            tipQualityTextView.text = "awesome"
            tipQualityTextView.setTextColor(getColor(R.color.awesome))
        }
        else if (tipPercent >= 21) {
            tipQualityTextView.text = "great"
            tipQualityTextView.setTextColor(getColor(R.color.great))
        }
        else if (tipPercent >= 16) {
            tipQualityTextView.text = "good"
            tipQualityTextView.setTextColor(getColor(R.color.good))
        }
        else if (tipPercent >= 10) {
            tipQualityTextView.text = "ok"
            tipQualityTextView.setTextColor(getColor(R.color.ok))
        }
        else {
            tipQualityTextView.text = "poor"
            tipQualityTextView.setTextColor(getColor(R.color.poor))
        }
    }


    private fun fullCalc(tipPercent: Int, subtotal: Double){
        val grandTotal = calculateGrandTotal(subtotal, tipPercent)
        grandTotalAmtTextView.text = grandTotal.toString() //grand total is set
        val tipOnly = calculateOnlyTip(subtotal, tipPercent)
        tipAmtTextView.text = tipOnly.toString() //tip only is set
        tipQuality(tipPercent) //tip quality indicator is set
    }
}