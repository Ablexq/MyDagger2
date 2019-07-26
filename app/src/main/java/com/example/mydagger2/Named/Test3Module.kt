package com.example.mydagger2.Named

import dagger.Module
import dagger.Provides
import javax.inject.Named

@Module
class Test3Module {

    @Provides
    @Named("obj1")      //必须1/2
    fun getPerson1() = Person3()

    @Provides
    @Named("obj2")
    fun getPerson2() = Person3()

    @Provides
    @Named("obj3")
    fun getPerson3() = Person3()
}