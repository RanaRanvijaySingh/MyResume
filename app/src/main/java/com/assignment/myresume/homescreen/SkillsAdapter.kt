package com.assignment.myresume.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myresume.R

class SkillsAdapter : RecyclerView.Adapter<SkillViewHolder>() {

    private var list = ArrayList<String>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): SkillViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_skill, parent, false)
        return SkillViewHolder(view)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: SkillViewHolder, position: Int) {
        holder.tvSkill?.text = list.get(position)
    }

    /**
     * Set the list of skills and refresh the list.
     */
    fun setList(list: List<String>) {
        this.list = list as ArrayList<String>
        notifyDataSetChanged()
    }
}

/**
 * View holder for skill list item
 */
class SkillViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {

    var tvSkill: TextView? = null

    init {
        tvSkill = itemView.findViewById(R.id.tvSkill)
    }
}