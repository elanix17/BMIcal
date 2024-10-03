package com.example.bmical.title

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class TitleViewModel : ViewModel() {
    //    val weight = MutableLiveData<String>()
//    val hight = MutableLiveData<String>()
    private val _result = MutableLiveData<String>()
    val result: LiveData<String> get() = _result


    fun BMIcalculator(weight: Int, height: Int) {
        val heightInMeters = height / 100.0
        val BMIval = weight / (heightInMeters * heightInMeters)
        val formattedBMI = String.format("%.2f", BMIval)
        val category = getBMICategory(BMIval)
        updateResult(data = "BMI: $formattedBMI\nCategory: $category")
    }

    private fun getBMICategory(BMIval: Double): String {
        return when {
            BMIval < 18.5 -> "Lean"
            BMIval < 24.9 -> "Normal"
            BMIval < 29.9 -> "Overweight"
            else -> "Obese"
        }
    }
    fun updateResult(data: String) {
            _result.value = data
            Log.i("result", result.value.toString())
        }

}