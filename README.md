

https://blog.csdn.net/briblue/article/details/75578459



app build.gradle:

``` 
apply plugin: 'com.android.application'

apply plugin: 'kotlin-android'

apply plugin: 'kotlin-android-extensions'

android {
    compileSdkVersion 28
    buildToolsVersion "29.0.0"
    defaultConfig {
        applicationId "com.example.mydagger2"
        minSdkVersion 15
        targetSdkVersion 28
        versionCode 1
        versionName "1.0"
        testInstrumentationRunner "androidx.test.runner.AndroidJUnitRunner"
    }
    buildTypes {
        release {
            minifyEnabled false
            proguardFiles getDefaultProguardFile('proguard-android-optimize.txt'), 'proguard-rules.pro'
        }
    }
}

dependencies {
    implementation fileTree(dir: 'libs', include: ['*.jar'])
    implementation"org.jetbrains.kotlin:kotlin-stdlib-jdk7:$kotlin_version"
    implementation 'androidx.appcompat:appcompat:1.0.2'
    implementation 'androidx.core:core-ktx:1.0.2'
    implementation 'androidx.constraintlayout:constraintlayout:1.1.3'
    testImplementation 'junit:junit:4.12'
    androidTestImplementation 'androidx.test:runner:1.2.0'
    androidTestImplementation 'androidx.test.espresso:espresso-core:3.2.0'
}


```

project build.gradle:

``` 
// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    ext.kotlin_version = '1.3.31'
    repositories {
        google()
        jcenter()
        
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.4.2'
        classpath "org.jetbrains.kotlin:kotlin-gradle-plugin:$kotlin_version"
        // NOTE: Do not place your application dependencies here; they belong
        // in the individual module build.gradle files
    }
}

allprojects {
    repositories {
        google()
        jcenter()
        
    }
}

task clean(type: Delete) {
    delete rootProject.buildDir
}

```

gradle.properties : 

``` 
# Project-wide Gradle settings.
# IDE (e.g. Android Studio) users:
# Gradle settings configured through the IDE *will override*
# any settings specified in this file.
# For more details on how to configure your build environment visit
# http://www.gradle.org/docs/current/userguide/build_environment.html
# Specifies the JVM arguments used for the daemon process.
# The setting is particularly useful for tweaking memory settings.
org.gradle.jvmargs=-Xmx1536m
# When configured, Gradle will run in incubating parallel mode.
# This option should only be used with decoupled projects. More details, visit
# http://www.gradle.org/docs/current/userguide/multi_project_builds.html#sec:decoupled_projects
# org.gradle.parallel=true
# AndroidX package structure to make it clearer which packages are bundled with the
# Android operating system, and which are packaged with your app's APK
# https://developer.android.com/topic/libraries/support-library/androidx-rn
android.useAndroidX=true
# Automatically convert third-party libraries to use AndroidX
android.enableJetifier=true
# Kotlin code style for this project: "official" or "obsolete":
kotlin.code.style=official

```

# dagger2

``` 
https://github.com/google/dagger
```

dagger2的依赖
``` 
apply plugin: 'com.android.application'
apply plugin: 'kotlin-android'              //kotlin 
apply plugin: 'kotlin-android-extensions'   //kotlin
apply plugin: 'kotlin-kapt'                 //kotlin apt

dependencies {
    //dagger2 必须库
    implementation 'com.google.dagger:dagger:2.23.2'
    //dagger2 Java注解处理器
    annotationProcessor 'com.google.dagger:dagger-compiler:2.23.2'
    //dagger2 kotlin注解处理器
    kapt 'com.google.dagger:dagger-compiler:2.23.2'
}

```


# 相关常用注解：
  
@Inject
标记构造函数
标记属性

@Component
@Module
@Provides
@Qualifier和@Named
@Scope和@Singleton

1.对象类的构造方法上添加 @Inject
2.创建module类并添加 @Module ，在里面创建返回对象方法并添加 @Provides
3.创建component接口并添加 @Component，引入module类 ，在里面创建注入目标的方法 
4.build项目
5.目标类中注入对象 @Inject

# 错误

Dagger does not support injection into private fields

``` 
@Inject
@JvmField   //解决
var textView: TextView? = null

```
原因：@Inject成员不能是private的

# 错误

android.content.Context cannot be provided without an @Provides-annotated method.

``` 
class Test1Module(activity: Activity) {

    private val activity: Activity? = activity//解决

    @Provides
    fun getTextView(context: Context): TextView {
        return TextView(activity?.applicationContext)
    }
}
```
 # 错误
 
 java.lang.IllegalStateException: com.example.mydagger2.test1.Test1Module must be set
 
``` 
 DaggerTest1Component.builder()
     .test1Module(Test1Module(this))//  解决
     .build()
     .inject(this)
```

# 错误：
```
[Dagger/DuplicateBindings] 
com.example.mydagger2.test3.Person3 is bound multiple times:
```

# 错误

``` 
[Dagger/MissingBinding] 
java.lang.String cannot be provided without an 
@Inject constructor or an @Provides-annotated method
```

没有provider或者inject
如果component含有dependencies，可能没有向外面暴露

# 错误

``` 
 Types may only contain one @Inject constructor
    public Person3(@org.jetbrains.annotations.NotNull()
```
一个类的构造函数只能有一个有@inject

 
java: 
``` 
public class MyTextView extends TextView {
    public MyTextView(Context context) {
        this(context,null);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs) {
        this(context, attrs,-1);
    }

    public MyTextView(Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
}
```
kotlin:
``` 
class MyTextView : TextView {
    constructor(context: Context) :
            this(context, null)

    constructor(context: Context, attrs: AttributeSet?) :
            this(context, attrs, -1)

    constructor(context: Context, attrs: AttributeSet?, defStyleAttr: Int) :
            super(context, attrs, defStyleAttr)

}

```
 
 
 
 