package com.fahri.kisahnabiapp.data.response

import android.os.Parcelable
import com.google.gson.annotations.SerializedName
import kotlinx.parcelize.Parcelize

@Parcelize
data class NabiResponse (

    @field:SerializedName("name")
    val name : String? = null,

    @field:SerializedName("thn_kelahiran")
    val thnKelahiran : String? = null,

    @field:SerializedName("usia")
    val usia : String? = null,

    @field:SerializedName("description")
    val description : String? = null,

    @field:SerializedName("tmp")
    val tempat : String? = null,

    @field:SerializedName("image_url")
    val img : String? = null,

) : Parcelable