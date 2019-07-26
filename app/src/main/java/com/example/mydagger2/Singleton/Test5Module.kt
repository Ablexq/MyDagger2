package com.example.mydagger2.Singleton

import android.app.Activity
import android.widget.TextView
import dagger.Module
import dagger.Provides
import javax.inject.Singleton


@Module
class Test5Module constructor(private var activity: Activity) {
    //android.content.Context cannot be provided without an @Provides-annotated method.

    @Provides
    fun getTextView(): TextView {
        return TextView(activity.applicationContext)
    }

    @Provides
    @Singleton  //必须2/3
    fun getPerson(): Person5 {
        return Person5()
    }

}