package com.example.mydagger2.test1

import dagger.Component

@Component(modules = arrayOf(Test1Module::class))
interface Test1Component {

    fun inject(activity: Test1Activity) {}

}