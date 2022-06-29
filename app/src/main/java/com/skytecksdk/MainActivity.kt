package com.skytecksdk

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.skytech.model.Contact
import com.skytech.model.SkyTech
import com.skytech.model.UserCredentials

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val userCredentials =
            UserCredentials(
                "en", Contact(
                    "test@test.com", "Test Test",
                    "+994000000000"
                )
            )

        SkyTech.Builder().key("api_key")
            .appID("app_id")
            .userCredentials(userCredentials)
            .open(this)
    }
}