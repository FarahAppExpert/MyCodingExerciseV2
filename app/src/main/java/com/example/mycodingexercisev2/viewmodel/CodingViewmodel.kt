package com.example.mycodingexercisev2.viewmodel

import android.util.Log
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mycodingexercisev2.model.CodingModel
import com.example.mycodingexercisev2.repository.Coding_Repository
import com.example.mycodingexercisev2.util.Coding_Coroutines
import com.example.mycodingexercisev2.view.CodingListener


class CodingViewmodel: ViewModel() {
    var codingList = MutableLiveData<List<CodingModel>>()
    var codingListener: CodingListener? = null

    init {
        refreshList()
    }

    fun refreshList() {


        Coding_Coroutines.main {
            val codingResponse = Coding_Repository().getCodeList()
            if (codingResponse.isSuccessful) {
                codingResponse.body()?.let {
                    codingList?.value = it
                    Log.d("The List", codingList.toString())
                }
            } else {
                codingListener?.onFailure(codingResponse.message())
            }
        }
    }

    fun displayToast(codingModel: CodingModel) {
        codingListener?.onItemClick(codingModel)
    }
}