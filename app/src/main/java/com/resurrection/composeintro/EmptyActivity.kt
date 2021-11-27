package com.resurrection.composeintro

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity

class EmptyActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_empty)

        deneme { view, height -> }

    }

     fun deneme( action: (view: View, height: Int) -> Unit) {
        val view = View(this)
        val height = view.layoutParams.height
        action(view, height)
    }
}


