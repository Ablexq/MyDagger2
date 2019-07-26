package com.example.mydagger2.Qualifier

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydagger2.R
import kotlinx.android.synthetic.main.activity_test4.*
import javax.inject.Inject

class Test4Activity : AppCompatActivity() {

    @Inject
    @JvmField
    @UserThirdQualifier("obj1")
    var person1: Person4? = null

    @Inject
    @JvmField
    @UserThirdQualifier("obj2")
    var person2: Person4? = null

    @Inject
    @JvmField
    @UserThirdQualifier("obj3")
    var person3: Person4? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test4)


        DaggerTest4Component.builder().build().inject(this)
//        //或
//        DaggerTest4Component.create().inject(this)

        person1?.name = "xq1"
        person1?.sex = "man1"
        person1?.age = 10 ?: 12

        person2?.name = "xq2"
        person2?.sex = "man2"
        person2?.age = 16 ?: 12

        person3?.name = "xq"
        person3?.sex = "man"
        person3?.age = 18 ?: 12
        tv4.text = person3.toString()
            .plus("  \n  ")
            .plus(person2.toString())
            .plus("  \n  ")
            .plus(person1.toString())

    }


}
