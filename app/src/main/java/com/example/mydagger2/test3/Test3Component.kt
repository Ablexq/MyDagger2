package com.example.mydagger2.test3

import dagger.Component

@Component(modules = [Test3Module::class])
interface Test3Component {
    fun inject(activity: Test3Activity) {}
}
