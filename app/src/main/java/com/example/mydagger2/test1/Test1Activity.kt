package com.examp

import com.example.mydagger2.test1.DaggerTest1Component

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.example.mydagger2.test1.Person1
import javax.inject.Inject

class Test1Activity : AppCompatActivity() {

    @Inject
    var textView: TextView? = null
    @Inject
    var person1: Person1? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        DaggerTest1Component.create().inject(this)
        textView?.text = person1?.name ?: "default"

        setContentView(textView)
    }


}
