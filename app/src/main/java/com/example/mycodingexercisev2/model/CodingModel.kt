package com.example.mycodingexercisev2.model


import android.os.Parcelable
import com.google.gson.annotations.Expose
import com.google.gson.annotations.SerializedName
import kotlinx.android.parcel.Parcelize

@Parcelize
data class CodingModel(
    @SerializedName("userId")
    @Expose
    var userId: Int,
    @SerializedName("id")
    @Expose
    var id: Int,
    @SerializedName("title")
    @Expose
    var title: String,


): Parcelable
{
     private fun getUserid (userId : Int) : Int
     {
         return userId
     }

    private fun getId (id : Int) : Int
    {
        return id
    }

    private fun getTitile (title : String) : String
    {
        return title
    }

}