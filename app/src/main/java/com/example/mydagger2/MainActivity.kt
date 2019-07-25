package com.example.mydagger2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.mydagger2.test1.Test1Activity
import com.example.mydagger2.test2.Test2Activity
import com.example.mydagger2.test3.Test3Activity
import com.example.mydagger2.test4.Test4Activity
import com.example.mydagger2.test5.Test5Activity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btn1.setOnClickListener(this)
        btn2.setOnClickListener(this)
        btn3.setOnClickListener(this)
        btn4.setOnClickListener(this)
        btn5.setOnClickListener(this)
    }

    override fun onClick(v: View?) {
        when (v?.id) {
            R.id.btn1 -> startActivity(Intent(this, Test1Activity::class.java))
            R.id.btn2 -> startActivity(Intent(this, Test2Activity::class.java))
            R.id.btn3 -> startActivity(Intent(this, Test3Activity::class.java))
            R.id.btn4 -> startActivity(Intent(this, Test4Activity::class.java))
            R.id.btn5 -> startActivity(Intent(this, Test5Activity::class.java))
        }
    }

}
