package com.example.mydagger2.Qualifier

import dagger.Component

@Component(modules = [Test4Module::class])
interface Test4Component {
    fun inject(activity: Test4Activity) {}
}
