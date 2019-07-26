package com.example.mydagger2.Singleton

import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class Test5Activity : AppCompatActivity() {

    @Inject
    @JvmField
    //Dagger does not support injection into private fields
    var textView: TextView? = null

    @Inject
    @JvmField
    var person1: Person5? = null

    @Inject
    @JvmField
    var person2: Person5? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTest5Component.builder()
            .test5Module(Test5Module(this))
            .build()
            .inject(this)
        textView?.let {
            person1?.name ?: "default1"
            person2?.name ?: "default2"
            it.text = person1.toString() + " \n " + person2.toString()
            it.gravity = Gravity.CENTER
            it.setTextColor(Color.RED)
            it.textSize = 25f
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.JELLY_BEAN) {
                it.background = ColorDrawable(Color.CYAN)
            }
        }
        setContentView(textView)
    }


}
