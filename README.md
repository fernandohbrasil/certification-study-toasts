# Certification Study Toasts

This application is part of a series of Apps that I am developing following the Studies guide of [Associate Android Developer](https://developers.google.com/certification/associate-android-developer).

## Motivation 

The purpose of this application was to explore some possibilities that [Toast](https://developer.android.com/reference/android/widget/Toast) allows.

## Content

The following methods were covered

* void show()
* void cancel()
* void setDuration(int duration)

SDK 29
* void setGravity(int gravity, int xOffset, int yOffset)
* void setMargin(float horizontalMargin, float verticalMargin)

SDK R
* void addCallback(Toast.Callback callback)

Note: Up to Sdk 29, it was possible to customize a view to use in Toast. However in the Android R version, this will be deprecated. So I chose not to implement this, as this will be exclusive content for [Snackbar](https://developer.android.com/reference/com/google/android/material/snackbar/Snackbar), as recommended by the official documentation.

## Screenshots

![Android 29](screenshots/android-29.gif)
![Android R](screenshots/android-R.gif)

## This Repository

This repository currently has 2 branches.

* Master -> Contains the most current version of the App with SDK R
* android-29 -> With the Methods available in SDK 29.

## Final

This App is really simple, and was focused just in [Toast](https://developer.android.com/reference/android/widget/Toast), so no specific architecture was observed. Feel free to use this example to start your studys, change the code and add in your repository also.

Any question, bug or request. Open a issue!