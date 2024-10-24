package net.mattiascibien.connectwifi

/**
 * Defines the Wi-Fi Network Type
 */
enum class WiFiType {
    /**
     * Network has not security (password is empty)
     */
    Unsecured,

    /**
     * Network has WEP security (deprecated and not supported on Android)
     */
    Wep,

    /**
     * Network has WPA2 security
     */
    Wpa2,

    /**
     * Network has WPA3 security
     */
    Wpa3
}