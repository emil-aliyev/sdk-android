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

        SkyTech.Builder().key("rPyCMWFMk27ucwYPpZE6")
            .appID("f4ee05e97792cf5a5f249c8af2fc8068")
            .userCredentials(userCredentials)
            .open(this)
    }
}