package com.assignment.myresume.homescreen.companyscreen.projectsscreen

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentPagerAdapter
import com.assignment.myresume.homescreen.companyscreen.ProjectUi

class ProjectAdapter(
    fragmentManager: FragmentManager,
    private val list: List<ProjectUi>
) : FragmentPagerAdapter(fragmentManager) {

    override fun getCount(): Int {
        return list.size
    }

    override fun getItem(position: Int): Fragment {
        return ProjectFragment.getInstance(list[position])
    }
}