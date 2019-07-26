package com.example.mydagger2.Scope

import javax.inject.Inject

@UserThirdScope
class Person6 @Inject constructor() {

    var name: String? = null
    var age: Int = 0

}