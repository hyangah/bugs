https://golang.org/issues/12020

x/mobile: crash in gobind interface call

* Setup instruction

make sure gomobile init has been called.

edit android/myLib/build.gradle file to set GO and GOPATH fields.

import the android project (/android directory). Build.

* Note

I used jdk1.7.0_79.jdk.
