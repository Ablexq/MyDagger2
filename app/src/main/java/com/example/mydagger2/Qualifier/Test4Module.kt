package com.example.mydagger2.Qualifier

import dagger.Module
import dagger.Provides

@Module
class Test4Module {

    @Provides
    @UserThirdQualifier("obj1")     //必须1/2
    fun getPerson1() = Person4()

    @Provides
    @UserThirdQualifier("obj2")
    fun getPerson2() = Person4()

    @Provides
    @UserThirdQualifier("obj3")
    fun getPerson3() = Person4()
}