package com.yhcloud.mykotlinproject

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.item_list_fragment_main.view.*

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class MainAdapter(private val items: List<FunctionBean>, private var mainListListener: MainListListener): RecyclerView.Adapter<MainAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_fragment_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(items[position])

        holder.itemView.setOnClickListener{ v -> mainListListener.onItemClick(v, holder.layoutPosition)}

        holder.itemView.setOnLongClickListener { v -> mainListListener.onItemLongClick(v, holder.layoutPosition) }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
         fun bind(fb: FunctionBean) {
             view.tvTitle.text = fb.title
         }
    }
}

