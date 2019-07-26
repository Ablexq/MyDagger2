package com.example.mydagger2.Singleton

import dagger.Component
import javax.inject.Singleton

@Singleton//必须3/3
@Component(modules = [Test5Module::class])
interface Test5Component {

    fun inject(activity: Test5Activity) {}

}