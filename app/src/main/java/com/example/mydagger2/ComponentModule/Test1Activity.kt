package com.example.mydagger2.ComponentModule


import android.graphics.Color
import android.graphics.drawable.ColorDrawable
import android.os.Build
import android.os.Bundle
import android.view.Gravity
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import javax.inject.Inject

class Test1Activity : AppCompatActivity() {

    @Inject
    @JvmField
    //Dagger does not support injection into private fields
    var textView: TextView? = null

    @Inject
    @JvmField
    var person1: Person1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTest1Component.builder()
            .test1Module(Test1Module(this))
            // java.lang.IllegalStateException: com.example.mydagger2.test1.Test1Module must be set
            .build()
            .inject(this)
        textView?.let {
            it.text = person1?.name ?: "default"
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
