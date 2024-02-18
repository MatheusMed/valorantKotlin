package com.mmdevs.valorantapiapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class AgenteModel(@Json(name = "data")
                       val data: List<DataItem>?,
                       @Json(name = "status")
                       val status: Int? = 0
):Parcelable