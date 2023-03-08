package com.example.health

import android.content.Context
import java.util.*

class CalorieCountBean(c: Context) {
    private var model: CalorieCountViewModel = CalorieCountViewModel.getInstance(c)

    private var gender = ""
    private var dgender =  ""
    private var exercise = ""
    private var dexercise =  ""
    private var times = ""
    private var dtimes = 0.0

    private var errors = ArrayList<String>()

    fun setGender(genderx: String) {
        gender = genderx
    }
    fun setExercise(exercisex: String) {
        exercise = exercisex
    }
    fun setTimes(timesx: String) {
        times = timesx
    }

    fun resetData() {
        //resetData
    }

    fun isCalorieCountError(): Boolean {
        errors.clear()
        if (gender != "") { dgender = gender }
        else {
            errors.add("gender cannot be empty")
        }
        if (exercise != "") { dexercise = exercise }
        else {
            errors.add("exercise cannot be empty")
        }
        try {
            dtimes = times.toDouble()
        } catch (e: Exception) {
            errors.add("times is not a Double")
        }
        return errors.size > 0
    }

    fun errors(): String {
        return errors.toString()
    }

    fun calorieCount (): Double {
        return model.calorieCount(dgender, dexercise, dtimes)
    }
}
