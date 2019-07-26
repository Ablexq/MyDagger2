package com.example.mydagger2.Singleton

import javax.inject.Inject
import javax.inject.Singleton

@Singleton//必须1/3
class Person5 @Inject constructor() {

    var name: String? = null
    var age: Int = 0

}