package me.leig.mykotlinproject.module.book.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import me.leig.mykotlinproject.R
import me.leig.mykotlinproject.base.listener.AdaptListener
import me.leig.mykotlinproject.module.book.bean.BookBean
import kotlinx.android.synthetic.main.item_list_book.view.*
import kotlinx.android.synthetic.main.item_list_chart.view.*

/**
 *
 *
 * @author leig
 * @version 20170301
 *
 */

class BookAdapter(private val items: List<BookBean>, private var adaptListener: AdaptListener): RecyclerView.Adapter<BookAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent!!.context).inflate(R.layout.item_list_book, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder!!.bind(items[position])
        holder.itemView.setOnClickListener{view -> adaptListener.onItemClick(view, holder.layoutPosition) }
        holder.itemView.setOnLongClickListener { view -> adaptListener.onItemLongClick(view, holder.layoutPosition) }
    }

    override fun getItemCount(): Int {
        return items.size
    }

    inner class ViewHolder(private val view: View): RecyclerView.ViewHolder(view) {
        fun bind(bb: BookBean) {
            if (0 < bb.imageId) {
                view.imageView.setImageResource(bb.imageId)
            }
            view.tvTitle.text = bb.title
        }
    }
}