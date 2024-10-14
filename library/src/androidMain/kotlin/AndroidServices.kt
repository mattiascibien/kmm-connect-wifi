import android.content.Context
import android.net.ConnectivityManager
import android.net.wifi.WifiManager
import androidx.startup.Initializer

class AndroidServices(val wifiManager: WifiManager, val connectivityManager: ConnectivityManager) {
    companion object {
        lateinit var services: AndroidServices

        fun initialize(context: Context) : AndroidServices {
            services = AndroidServices(
                context.getSystemService(Context.WIFI_SERVICE) as WifiManager,
                context.getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
            )
            return services
        }

        fun getInstance() : AndroidServices {
            if (!::services.isInitialized) {
                throw Exception("AndroidServices not initialized. You might forgot to call initialize(ctx: Context) ")
            }

            return services
        }
    }
}

class AndroidServicesInitializer : Initializer<AndroidServices> {
    override fun create(context: Context): AndroidServices {
        return AndroidServices.initialize(context)
    }

    override fun dependencies(): MutableList<Class<out Initializer<*>>> {
        return emptyList<Class<out Initializer<*>>>().toMutableList()
    }
}