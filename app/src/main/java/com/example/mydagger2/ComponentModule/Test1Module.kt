package com.example.mydagger2.ComponentModule

import android.app.Activity
import android.widget.TextView
import dagger.Module
import dagger.Provides

@Module
class Test1Module constructor(private var activity: Activity) {
    //android.content.Context cannot be provided without an @Provides-annotated method.

    @Provides
    fun getTextView(): TextView {
        return TextView(activity.applicationContext)
    }

    @Provides
    fun getPerson(): Person1 {
        return Person1()
    }

}