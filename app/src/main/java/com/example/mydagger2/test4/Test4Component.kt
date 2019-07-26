package com.example.mydagger2.test4

import dagger.Component

@Component(modules = [Test4Module::class])
interface Test4Component {
    fun inject(activity: Test4Activity) {}
}
