package com.example.mycodingexercisev2.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.mycodingexercisev2.R
import com.example.mycodingexercisev2.adapter.CodeClick
import com.example.mycodingexercisev2.model.CodingModel
import com.example.mycodingexercisev2.databinding.ActivityMainBinding
import com.example.mycodingexercisev2.viewmodel.CodingViewmodel
import com.example.mycodingexercisev2.adapter.ListAdapter


class MainActivity : AppCompatActivity(), CodingListener {
    private var listAdapter: ListAdapter? = null
    private val viewModel by lazy {
        ViewModelProvider(this).get(CodingViewmodel::class.java)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        val binding: ActivityMainBinding =
            DataBindingUtil.setContentView(this, R.layout.activity_main)

        binding.setLifecycleOwner(this)
        binding.listViewModel = viewModel
        viewModel.codingListener = this

        listAdapter = ListAdapter(CodeClick {
            viewModel.displayToast(it)
        })

        binding.ListRecyclerview.apply {
            layoutManager = LinearLayoutManager(this.context, RecyclerView.VERTICAL, false)
            adapter = listAdapter
        }



        viewModel.codingList?.observe(this,
                {
                    codeList ->
                    codeList?.apply {
                        listAdapter?.codeList = this
                    }
                })
    }

    override fun onFailure(message: String) {
        Toast.makeText(this, message, Toast.LENGTH_LONG).show()
    }

    override fun onItemClick(codeModel: CodingModel) {
        codeModel.userId?.let { Toast.makeText(this, it, Toast.LENGTH_LONG).show() }
        Toast.makeText(this, codeModel.title, Toast.LENGTH_LONG).show()
    }
}