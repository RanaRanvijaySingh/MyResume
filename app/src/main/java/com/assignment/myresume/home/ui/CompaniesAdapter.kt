package com.assignment.myresume.home.ui

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myresume.R
import com.assignment.myresume.home.domain.Company

class CompaniesAdapter(
    private val listener: CompanySelectListener
) : RecyclerView.Adapter<CompanyViewHolder>() {

    private var list = ArrayList<Company>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_company, parent, false)
        return CompanyViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val company: Company = list.get(position)
        holder.company = company
        holder.tvCompany?.text = company.name
    }

    fun setList(list: List<Company>) {
        this.list = list as ArrayList<Company>
        notifyDataSetChanged()
    }
}


class CompanyViewHolder(
    itemView: View,
    private val listener: CompanySelectListener
) : RecyclerView.ViewHolder(itemView) {

    lateinit var company: Company
    var tvCompany: TextView? = null

    init {
        tvCompany = itemView.findViewById(R.id.tvCompany)
        itemView.setOnClickListener {
            listener.companySelected(company)
        }
    }
}

interface CompanySelectListener {
    fun companySelected(company: Company)
}