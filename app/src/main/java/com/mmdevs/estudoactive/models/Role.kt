package com.mmdevs.valorantapiapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Role(@Json(name = "displayIcon")
                val displayIcon: String = "",
                @Json(name = "displayName")
                val displayName: String = "",
                @Json(name = "assetPath")
                val assetPath: String = "",
                @Json(name = "description")
                val description: String = "",
                @Json(name = "uuid")
                val uuid: String = ""):Parcelable