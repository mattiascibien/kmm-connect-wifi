package net.mattiascibien.connectwifi

expect suspend fun connectToWifi(ssid: String, type: WiFiType, password: String? = null) : Boolean