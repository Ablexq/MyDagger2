package com.example.mydagger2.Scope

import android.app.Activity
import android.widget.TextView
import dagger.Module
import dagger.Provides


@Module
class Test6Module constructor(private var activity: Activity) {
    //android.content.Context cannot be provided without an @Provides-annotated method.

    @Provides
    fun getTextView(): TextView {
        return TextView(activity.applicationContext)
    }

    @Provides
    @UserThirdScope //必须2/3
    fun getPerson(): Person6 {
        return Person6()
    }

}