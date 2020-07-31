package com.customizeln

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

/**
 * @author: hs-johnny
 * @date: 2020/7/29
 * @description:
 */
class AnimHomeAdapter constructor(val onItemListener: OnItemListener) : RecyclerView.Adapter<AnimHomeAdapter.ViewHolder>(){

    val titles = arrayListOf<String>().apply {
        add("圆形放大")
        add("原点移动")
        add("头像翻折")
        add("地区替换")
    }

    inner class ViewHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView){
        val title = itemView.findViewById<TextView>(R.id.title)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_home, parent, false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int = titles.size

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.title.text = titles[position]
        holder.itemView.setOnClickListener {
            onItemListener.onClick(position)
        }
    }

    interface OnItemListener{
        fun onClick(position: Int)
    }
}