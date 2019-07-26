package com.example.mydagger2.Inject

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydagger2.R
import kotlinx.android.synthetic.main.activity_test2.*
import javax.inject.Inject

class Test2Activity : AppCompatActivity() {

    @Inject     //必须2/2
    @JvmField
    //Dagger does not support injection into private fields
    var person2: Person2? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test2)

        tv2.text = person2?.name ?: "xq2"
    }


}
