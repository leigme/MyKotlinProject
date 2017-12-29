package com.yhcloud.mykotlinproject.module.chart.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.yhcloud.mykotlinproject.base.AdaptListener
import com.yhcloud.mykotlinproject.R
import com.yhcloud.mykotlinproject.module.chart.bean.ChartBean
import kotlinx.android.synthetic.main.item_list_chart.view.*

/**
 * 图表适配器
 *
 * @author leig
 * @version 20170301
 *
 */

class ChartAdapter(private val items: List<ChartBean>, private var adaptListener: AdaptListener): RecyclerView.Adapter<ChartAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_chart, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(items[position])
        holder.itemView.setOnClickListener{view -> adaptListener.onItemClick(view, holder.layoutPosition) }
        holder.itemView.setOnLongClickListener { view -> adaptListener.onItemLongClick(view, holder.layoutPosition) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(cb: ChartBean) {
            if (0 < cb.imageId) {
                view.imageView.setImageResource(cb.imageId)
            }
            view.textView.text = cb.title
        }
    }
}