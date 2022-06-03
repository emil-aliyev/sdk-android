package com.skytech.util

import android.content.Context
import android.content.SharedPreferences

class Preferences(context: Context) {
    private var sharedPreferences: SharedPreferences =
        context.getSharedPreferences("MY_PREFS_NAME", Context.MODE_PRIVATE)

    fun saveToPrefs(key: String?, value: Any) {
        val editor = sharedPreferences.edit()
        when (value) {
            is Int -> {
                editor.putInt(key, value.toInt())
            }
            is String -> {
                editor.putString(key, value.toString())
            }
            is Boolean -> {
                editor.putBoolean(key, value)
            }
            is Long -> {
                editor.putLong(key, value.toLong())
            }
            is Float -> {
                editor.putFloat(key, value.toFloat())
            }
            is Double -> {
                editor.putLong(key, java.lang.Double.doubleToRawLongBits(value))
            }
        }
        editor.apply()
    }

    fun getFromPrefs(key: String?, defaultValue: Any): Any {
        try {
            when (defaultValue) {
                is String -> {
                    return sharedPreferences.getString(key, defaultValue) as String
                }
                is Int -> {
                    return sharedPreferences.getInt(key, defaultValue.toInt())
                }
                is Boolean -> {
                    return sharedPreferences.getBoolean(key, defaultValue)
                }
                is Long -> {
                    return sharedPreferences.getLong(key, defaultValue.toLong())
                }
                is Float -> {
                    return sharedPreferences.getFloat(key, defaultValue.toFloat())
                }
                is Double -> {
                    return java.lang.Double.longBitsToDouble(
                        sharedPreferences.getLong(
                            key, java.lang.Double.doubleToLongBits(
                                defaultValue
                            )
                        )
                    )
                }
            }
        } catch (e: Exception) {
            e.printStackTrace()
            return defaultValue
        }
        return defaultValue
    }

    fun removeFromPrefs(key: String?) {
        val editor = sharedPreferences.edit()
        editor.remove(key).apply()
    }

    fun hasKey(key: String?): Boolean {
        return sharedPreferences.contains(key)
    }

}