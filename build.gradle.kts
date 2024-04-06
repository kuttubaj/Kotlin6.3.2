// Top-level build file where you can add configuration options common to all sub-projects/modules.
plugins {
    id("com.android.application") version "8.2.2" apply false
    id("org.jetbrains.kotlin.android") version "1.9.22" apply false
    //Hilt
    id("com.google.dagger.hilt.android") version "2.51" apply false
    // Safe args
    id ("androidx.navigation.safeargs.kotlin") version "2.7.7" apply false
}