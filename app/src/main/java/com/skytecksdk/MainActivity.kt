package com.skytecksdk

import android.os.Bundle
import android.os.CountDownTimer
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.skytech.manager.ChatSdkManager
import com.skytech.model.SkyTech
import org.json.JSONObject

class MainActivity : AppCompatActivity() {
    val TAG = "geek"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val credentials = JSONObject()
        credentials.put("language", "en")

        val contact = JSONObject()
        val identity = JSONObject()

        contact.put("email", "user@test.com")
        contact.put("fullname", "name Surname")
        contact.put("phone", "+994XXXXXXX")

        identity.put("field", "email")

        credentials.put("contact", contact)
        credentials.put("identity", identity)

        SkyTech.Builder()
            .key("api_key")
            .appID("app_id")
            .firebaseToken("your_fb_token")
            .userCredentials(credentials)
            .open(this)
    }
}
