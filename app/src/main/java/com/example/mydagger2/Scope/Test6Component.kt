package com.example.mydagger2.Scope

import dagger.Component

@Component(modules = [Test6Module::class])
@UserThirdScope
interface Test6Component {

    fun inject(activity: Test6Activity) {}

}