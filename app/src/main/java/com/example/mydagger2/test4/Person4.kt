package com.example.mydagger2.test4

import javax.inject.Inject


class Person4 constructor(name: String?, age: Int, sex: String?) {

    var name: String? = name
    var age: Int = age
    var sex: String? = sex

    @Inject
    constructor() : this(null, -1, null)

    constructor(name: String, age: Int) : this(name, 0, null) {
        this.name = name
        this.age = age
        this.sex = sex
    }

    constructor(name: String) : this(name, 0) {
        this.name = name
        this.age = age
        this.sex = sex
    }
}