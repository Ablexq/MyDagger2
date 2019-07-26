package com.example.mydagger2.Named

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.mydagger2.R
import kotlinx.android.synthetic.main.activity_test3.*
import javax.inject.Inject
import javax.inject.Named

class Test3Activity : AppCompatActivity() {


    @Inject
    @JvmField
    @Named("obj1")      //必须2/2
    var person1: Person3? = null

    @Inject
    @JvmField
    @Named("obj2")
    var person2: Person3? = null

    @Inject
    @JvmField
    @Named("obj3")
    var person3: Person3? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_test3)

        DaggerTest3Component.builder().build().inject(this)
//        //或
//        DaggerTest3Component.create().inject(this)

        person1?.name = "xq1"
        person1?.sex = "man1"
        person1?.age = 10 ?: 12

        person2?.name = "xq2"
        person2?.sex = "man2"
        person2?.age = 16 ?: 12

        person3?.name = "xq"
        person3?.sex = "man"
        person3?.age = 18 ?: 12
        tv3.text = person3.toString()
            .plus("  \n  ")
            .plus(person2.toString())
            .plus("  \n  ")
            .plus(person1.toString())

    }


}
