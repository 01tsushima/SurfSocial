// Top-level build file where you can add configuration options common to all sub-projects/modules.

buildscript {
    extra.apply{
        //todo refactor
        set("compose_version",Dep.composeVersion)
    }
    repositories {
        google()
        mavenCentral()
    }
    dependencies {
        classpath ("com.android.tools.build:gradle:${Dep.gradle}")
        classpath ("org.jetbrains.kotlin:kotlin-gradle-plugin:${Dep.kotlinVersion}")
        classpath("com.google.dagger:hilt-android-gradle-plugin:${Dep.hiltCoreVersion}")
    }
}

tasks.register(name = "type",type = Delete::class){
    delete(rootProject.buildDir)
}