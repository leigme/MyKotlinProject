package com.yhcloud.mykotlinproject.module.function.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.AdaptListener
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.module.function.bean.FunctionBean
import kotlinx.android.synthetic.main.item_list_main.view.*

/**
 * 功能适配器
 *
 * @author leig
 * @version 20170301
 *
 */

class FunctionAdapter(private val items: List<FunctionBean>, private var adaptListener: AdaptListener): RecyclerView.Adapter<FunctionAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_main, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(items[position])

        holder.itemView.setOnClickListener{ v -> adaptListener.onItemClick(v, holder.layoutPosition)}

        holder.itemView.setOnLongClickListener { v -> adaptListener.onItemLongClick(v, holder.layoutPosition) }
    }

    override fun getItemCount(): Int = items.size

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
         fun bind(fb: FunctionBean) {
             view.tvTitle.text = fb.title
         }
    }
}

