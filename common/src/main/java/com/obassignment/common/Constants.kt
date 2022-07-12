package com.obassignment.common

import java.math.BigInteger
import java.security.MessageDigest
import java.sql.Timestamp

class Constants {
    companion object {
        const val BASE_URL = "https://gateway.marvel.com/"
        const val PUBLIC_API_KEY = "fcf9a89dd88a8f74de6a92ffa8deccc6"
        const val PRIVATE_API_KEY = "6c4ef130f305ddee7ff7941e99e5054290259d0e"
        val timeStamp = Timestamp(System.currentTimeMillis()).time.toString()

        fun hash(): String{
            val input = "$timeStamp$PRIVATE_API_KEY$PUBLIC_API_KEY"
            val md = MessageDigest.getInstance("MD5")
            return BigInteger(1,md.digest(input.toByteArray())).toString(16);
        }

    }

}