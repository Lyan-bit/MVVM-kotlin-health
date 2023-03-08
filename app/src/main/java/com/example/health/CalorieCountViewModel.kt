package com.example.health

import android.content.Context

class CalorieCountViewModel private constructor(context: Context) {

    companion object {
        private var instance: CalorieCountViewModel? = null
        fun getInstance(context: Context): CalorieCountViewModel {
            return instance ?: CalorieCountViewModel(context)
        }
    }

    fun calorieCount(gender: String, exercise: String, times: Double): Double {

        val calories: Double
        var factor: Double
        factor  = 1.0
        if (exercise == "walking") {
            factor  = 100.0
        } else {
            if (exercise == "running") {
                factor  = 300.0
            } else {
                if (exercise == "jogging") {
                    factor  = 200.0
                } else {
                    factor  = 250.0
                }
            }
        }
        calories  = factor * (times / 60.0)
        return calories
    }

}
