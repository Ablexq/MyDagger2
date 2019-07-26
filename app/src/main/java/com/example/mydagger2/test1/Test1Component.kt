package com.example.mydagger2.test1

import dagger.Component

@Component(modules = [Test1Module::class])
interface Test1Component {

    fun inject(activity: Test1Activity) {}

}