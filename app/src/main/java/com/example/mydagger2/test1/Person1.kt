package com.example.mydagger2.test1

import javax.inject.Inject


class Person1 @Inject constructor() {

    var name: String? = null
        get() = "xq"
    var age: Int = 0

}