package com.mmdevs.valorantapiapp.models

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class DataItem(@Json(name = "killfeedPortrait")
                    val killfeedPortrait: String? = "",
                    @Json(name = "role")
                    val role: Role?,
                    @Json(name = "isFullPortraitRightFacing")
                    val isFullPortraitRightFacing: Boolean = false,
                    @Json(name = "displayName")
                    val displayName: String? = "",
                    @Json(name = "isBaseContent")
                    val isBaseContent: Boolean = false,
                    @Json(name = "description")
                    val description: String? = "",
                    @Json(name = "backgroundGradientColors")
                    val backgroundGradientColors: List<String>?,
                    @Json(name = "isAvailableForTest")
                    val isAvailableForTest: Boolean = false,
                    @Json(name = "uuid")
                    val uuid: String? = "",
                    @Json(name = "displayIconSmall")
                    val displayIconSmall: String? = "",
                    @Json(name = "fullPortrait")
                    val fullPortrait: String? = "",
                    @Json(name = "fullPortraitV2")
                    val fullPortraitV: String? = "",
                    @Json(name = "abilities")
                    val abilities: List<AbilitiesItem>?,
                    @Json(name = "displayIcon")
                    val displayIcon: String? = "",
                    @Json(name = "bustPortrait")
                    val bustPortrait: String? = "",
                    @Json(name = "background")
                    val background: String? = "",
                    @Json(name = "assetPath")
                    val assetPath: String? = "",
                    @Json(name = "isPlayableCharacter")
                    val isPlayableCharacter: Boolean = false,
                    @Json(name = "developerName")
                    val developerName: String? = ""
):Parcelable