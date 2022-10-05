package com.example.retrofitposttoken

data class SignUpForm(
    val name: String,

    val username: String,
    val email: String,
    val role: Array<String>,
    val password: String,

    )


//{
//    "name": "string",
//    "username": "string",
//    "email": "string",
//    "role": [
//    "string"
//    ],
//    "password": "string"
//}