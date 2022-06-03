package com.skytech.model

data class UserCredentials(val language: String, val contact: Contact)

data class Contact(
    val email: String,
    val fullname: String,
    val phone: String,
)