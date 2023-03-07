package com.example.health

import android.content.Context


class ComputeBMIViewModel private constructor(context: Context) {

    companion object {
        private var instance: ComputeBMIViewModel? = null
        fun getInstance(context: Context): ComputeBMIViewModel {
            return instance ?: ComputeBMIViewModel(context)
        }
    }

    fun computeBMI (heights: Double, weight: Double): Double {
        var result = 0.0
        result  = weight / (heights * heights)
        return result
    }

}
