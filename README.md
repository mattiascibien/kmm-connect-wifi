# kmm-connect-wifi

kmm-connect-wifi is a Kotlin Multiplatform Library that lets you connect to a specific Wi-Fi network in a cross-platform way, on Android (10+) and iOS.

It exposes a single async method ` connectToWifi(ssid: String, type: WiFiType, password: String?)` that accepts:
 
  - `ssid`: the SSID of the network you wish to connect
  - `type`: the newtork type you are connecting to that can be:
    - `Unsecured`:  Network has no security. Do now specify `password`in this case
    - `Wep`:  Network has WEP security. It is an old deprecated security protocol and it is not supported on Android
    - `Wpa2`
    - `Wpa3`
 - `password`: the password of the Netowork

Various prompts and messages box may happen during the process, depending on the Operating System. In the end you will receive the result indicating wheter the connection is successful or not.

## Installation

At the moment the library is available on Github Packages but it is in the process of being published to Maven Central when it reaches a stable version. Follow the instructions on [Github Docs](https://docs.github.com/en/packages/working-with-a-github-packages-registry/working-with-the-gradle-registry#using-a-published-package) to learn how to add the repository to your project and then add the package to your `build.gradle.kts`.
