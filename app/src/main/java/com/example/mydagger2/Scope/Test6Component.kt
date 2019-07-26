package com.example.mydagger2.Scope

import dagger.Component

@Component(modules = [Test6Module::class])
@UserThirdScope //必须3/3
interface Test6Component {

    fun inject(activity: Test6Activity) {}

}