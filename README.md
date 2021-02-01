# MVVM Urban Dictionary
Simple app to fetch words using Urgan Dictionary API using MVVM

[![Kotlin Version](https://img.shields.io/badge/Kotlin-1.4.20-blue.svg)](https://kotlinlang.org)
[![AGP](https://img.shields.io/badge/AGP-4.1.2-blue?style=flat)](https://developer.android.com/studio/releases/gradle-plugin)
[![Gradle](https://img.shields.io/badge/Gradle-6.5.0-blue?style=flat)](https://gradle.org)

[![API](https://img.shields.io/badge/API-21%2B-brightgreen.svg?style=flat)](https://android-arsenal.com/api?level=21)
[![CircleCI](https://circleci.com/gh/gonzaloguzzardi/dictionary-app/tree/main.svg?style=shield)](https://circleci.com/gh/gonzaloguzzardi/dictionary-app/main/teesloane-patch-5)
[![Awesome Kotlin Badge](https://kotlin.link/awesome-kotlin.svg)](https://github.com/KotlinBy/awesome-kotlin)

Require Android Studio 4.1

## Project characteristics
* 100% [Kotlin](https://kotlinlang.org/)
* MVVM
* Flow
* [Android Jetpack](https://developer.android.com/jetpack)
* Single-activity architecture ([Navigation component](https://developer.android.com/guide/navigation/navigation-getting-started))
* Reactive UI
* [View Binding](https://developer.android.com/topic/libraries/view-binding)
* Testing (Unit, UI)
* Static analysis tools
* Material design

## Tech-stack

<img src="assets/app-gif.gif" width="280" align="right" hspace="20">

Min API level is set to [`21`](https://android-arsenal.com/api?level=21)

* Tech-stack
    * [Kotlin](https://kotlinlang.org/) + [Coroutines](https://kotlinlang.org/docs/reference/coroutines-overview.html) + [Flow](https://kotlinlang.org/docs/reference/coroutines/flow.html)- perform background operations
    * [Retrofit](https://square.github.io/retrofit/) - networking
    * [Jetpack](https://developer.android.com/jetpack)
        * [Navigation](https://developer.android.com/topic/libraries/architecture/navigation/) - deal with whole in-app navigation
        * [LiveData](https://developer.android.com/topic/libraries/architecture/livedata) - notify views about database change
        * [ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel) - store and manage UI-related data in a lifecycle conscious way
* Architecture
    * MVVM
    * [Android Architecture components](https://developer.android.com/topic/libraries/architecture) ([ViewModel](https://developer.android.com/topic/libraries/architecture/viewmodel), [LiveData](https://developer.android.com/topic/libraries/architecture/livedata), [Navigation](https://developer.android.com/jetpack/androidx/releases/navigation), [SafeArgs](https://developer.android.com/guide/navigation/navigation-pass-data#Safe-args) plugin)
* Tests
    * [Unit Tests](https://en.wikipedia.org/wiki/Unit_testing) ([JUnit](https://junit.org/junit4/))
* Gradle
    * [Detekt](https://github.com/arturbosch/detekt#with-gradle)

## Architecture

<p align="center">
  <img src="https://github.com/gonzaloguzzardi/android-clean-arquitecture/blob/main/assets/clean-arquitecture-image.png?raw=true" width="450" />
</p>

## Getting started
To open this project follow any of the next steps:
### Android Studio 4.1

1. Android Studio -> File -> New -> From Version control -> Git
2. Enter `https://github.com/gonzaloguzzardi/dictionary-app.git` into URL field
3. Open secrets.properties file and set your [RapidApiKey](https://rapidapi.com/community/api/urban-dictionary/)

### Command-line + Android Studio 4.1

1. Run `git clone https://github.com/gonzaloguzzardi/dictionary-app.git`
2. Android Studio -> File -> Open
3. Open secrets.properties file and set your [RapidApiKey](https://rapidapi.com/community/api/urban-dictionary/)
