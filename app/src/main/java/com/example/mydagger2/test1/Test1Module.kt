package com.example.mydagger2.test1

import android.content.Context
import android.widget.TextView
import dagger.Module
import dagger.Provides

@Module
class Test1Module {


    @Provides
    fun getTextView(context: Context): TextView {
        return TextView(context)
    }

    @Provides
    fun getPerson(): Person1 {
        return Person1()
    }

}