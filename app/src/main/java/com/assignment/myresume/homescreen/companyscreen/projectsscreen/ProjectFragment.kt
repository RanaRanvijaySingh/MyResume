package com.assignment.myresume.homescreen.companyscreen.projectsscreen

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.assignment.myresume.R
import com.assignment.myresume.homescreen.companyscreen.ProjectUi
import com.assignment.myresume.utils.Constants
import kotlinx.android.synthetic.main.fragment_project.*

class ProjectFragment private constructor() : Fragment() {

    var project: ProjectUi? = null

    companion object {
        fun getInstance(projectUi: ProjectUi): ProjectFragment {
            val fragment = ProjectFragment()
            val bundle = Bundle()
            bundle.putParcelable(Constants.IntentKeys.PROJECT, projectUi)
            fragment.arguments = bundle
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_project, null)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        project = arguments?.getParcelable<ProjectUi>(Constants.IntentKeys.PROJECT)
        project?.apply { tvProject.text = name }
    }
}