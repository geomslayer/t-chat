package com.geomslayer.tchat.dialogs

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.geomslayer.tchat.DialogItem
import com.geomslayer.tchat.R
import kotlinx.android.synthetic.main.item_chat_dialog.view.*

class DialogAdapter : RecyclerView.Adapter<DialogAdapter.ViewHolder>() {

    var dataset: MutableList<DialogItem> = arrayListOf()
        set(value) {
            field = value
            notifyDataSetChanged()
        }

    var clickListener: (Int) -> Unit = {}

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bindDialog(dataset[position])
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
                .inflate(R.layout.item_chat_dialog, parent, false)
        return ViewHolder(view, clickListener)
    }

    override fun getItemCount() = dataset.size

    class ViewHolder(view: View, listener: (Int) -> Unit) : RecyclerView.ViewHolder(view) {

        init {
            itemView.setOnClickListener { listener(adapterPosition) }
        }

        fun bindDialog(dialog: DialogItem) = with(itemView) {
            dialogTitleTextView.text = dialog.title
            dialogDescTextView.text = dialog.desc
        }

    }

}