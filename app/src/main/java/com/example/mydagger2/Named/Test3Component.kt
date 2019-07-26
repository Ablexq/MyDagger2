package com.example.mydagger2.Named

import dagger.Component

@Component(modules = [Test3Module::class])
interface Test3Component {
    fun inject(activity: Test3Activity) {}
}
