package com.skytech.util

import android.content.Context
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.net.ConnectivityManager
import android.net.NetworkCapabilities
import okhttp3.internal.and
import javax.crypto.Mac
import javax.crypto.spec.SecretKeySpec

object Utils {

    fun hmac(
        data: String?,
        key: String?
    ): String {

        return try {
            val signingKey = SecretKeySpec(key?.toByteArray(Charsets.UTF_8), "HmacSHA256")
            val mac: Mac = Mac.getInstance("HmacSHA256")
            mac.init(signingKey)
            val rawHmac: ByteArray = mac.doFinal(data?.toByteArray(Charsets.UTF_8))
            val hexArray = byteArrayOf(
                '0'.toByte(),
                '1'.toByte(),
                '2'.toByte(),
                '3'.toByte(),
                '4'.toByte(),
                '5'.toByte(),
                '6'.toByte(),
                '7'.toByte(),
                '8'.toByte(),
                '9'.toByte(),
                'a'.toByte(),
                'b'.toByte(), 'c'.toByte(), 'd'.toByte(), 'e'.toByte(), 'f'.toByte()
            )
            val hexChars = ByteArray(rawHmac.size * 2)
            for (j in rawHmac.indices) {
                val v: Int = rawHmac[j] and 0xFF
                hexChars[j * 2] = hexArray[v ushr 4]
                hexChars[j * 2 + 1] = hexArray[v and 0x0F]
            }
            String(hexChars)
        } catch (ex: Exception) {
            throw RuntimeException(ex)
        }
    }

    fun Context.isOnline(): Boolean {
        val connectivityManager =
            getSystemService(Context.CONNECTIVITY_SERVICE) as ConnectivityManager
        val capabilities =
            connectivityManager.getNetworkCapabilities(connectivityManager.activeNetwork)
        if (capabilities != null) {
            when {
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_CELLULAR) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_WIFI) -> {
                    return true
                }
                capabilities.hasTransport(NetworkCapabilities.TRANSPORT_ETHERNET) -> {
                    return true
                }
            }
        }
        return false
    }
}