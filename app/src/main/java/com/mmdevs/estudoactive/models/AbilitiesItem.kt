package com.mmdevs.valorantapiapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class AbilitiesItem(@Json(name = "displayIcon")
                         val displayIcon: String? = "",
                         @Json(name = "displayName")
                         val displayName: String? = "",
                         @Json(name = "description")
                         val description: String? = "",
                         @Json(name = "slot")
                         val slot: String? = ""): Parcelable