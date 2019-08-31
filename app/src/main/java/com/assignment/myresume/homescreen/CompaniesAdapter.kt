package com.assignment.myresume.homescreen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myresume.R

class CompaniesAdapter(
    private val listener: CompanySelectListener
) : RecyclerView.Adapter<CompanyViewHolder>() {

    private var list = ArrayList<CompanyUi>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CompanyViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.list_item_company, parent, false)
        return CompanyViewHolder(view, listener)
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun onBindViewHolder(holder: CompanyViewHolder, position: Int) {
        val company: CompanyUi = list.get(position)
        holder.company = company
        holder.tvCompany?.text = company.name
    }

    /**
     * Set the list of companies and refresh the list.
     */
    fun setList(list: List<CompanyUi>) {
        this.list = list as ArrayList<CompanyUi>
        notifyDataSetChanged()
    }
}

/**
 * View holder for company list item
 */
class CompanyViewHolder(
    itemView: View,
    private val listener: CompanySelectListener
) : RecyclerView.ViewHolder(itemView) {

    lateinit var company: CompanyUi
    var tvCompany: TextView? = null

    init {
        tvCompany = itemView.findViewById(R.id.tvCompany)
        itemView.setOnClickListener {
            listener.companySelected(company)
        }
    }
}

/**
 * Interface for getting selected company back to calling class.
 */
interface CompanySelectListener {
    fun companySelected(company: CompanyUi)
}