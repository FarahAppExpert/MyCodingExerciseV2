package com.example.mycodingexercisev2.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.LayoutRes
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.RecyclerView;
import com.example.mycodingexercisev2.R
import com.example.mycodingexercisev2.model.CodingModel
import com.example.mycodingexercisev2.databinding.ListViewBinding


class ListAdapter(val codeListener: CodeClick): RecyclerView.Adapter<ViewHolder>()  {

        var codeList: List<CodingModel> = emptyList()
        set(value) {
                field = value
                notifyDataSetChanged()
        }

        override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
                val withDataBinding: ListViewBinding = DataBindingUtil.inflate(

                        LayoutInflater.from(parent.context),

                        ViewHolder.LAYOUT,

                        parent,
                        false
                )
                return ViewHolder(withDataBinding)
        }

        override fun onBindViewHolder(holder: ViewHolder, position: Int) {
                holder.viewDatabinding.also {
                        it.codingModel = codeList[position]
                        it.codeClickBack = codeListener
                }
        }

        override fun getItemCount(): Int {
                return codeList.size
        }
}

class ViewHolder(val viewDatabinding: ListViewBinding): RecyclerView.ViewHolder(viewDatabinding.root) {
        companion object {
                @LayoutRes
                val LAYOUT = R.layout.list_view
        }
}

class CodeClick(val block: (CodingModel)->Unit) {
        fun onClick(code: CodingModel) = block(code)
}