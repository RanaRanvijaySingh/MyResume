package com.assignment.myresume.homescreen.companyscreen.projectsscreen

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.R
import com.assignment.myresume.homescreen.companyscreen.CompanyDetailUi
import com.assignment.myresume.homescreen.companyscreen.ProjectUi
import com.assignment.myresume.utils.Constants
import kotlinx.android.synthetic.main.activity_company.toolbar
import kotlinx.android.synthetic.main.activity_projects.*
import java.util.ArrayList

class ProjectsActivity : AppCompatActivity() {

    private var projects: List<ProjectUi>? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dagger injection
        MyResumeApplication.appComponent.inject(this)
        setContentView(R.layout.activity_projects)

        // Get company detail data url from intent
        val bundle = intent.extras
        bundle?.apply {
            projects = getParcelableArrayList(Constants.IntentKeys.PROJECTS)
            val companyName = getString(Constants.IntentKeys.COMPANY_NAME)
            initToolbar(companyName)
        }
        projects?.let { initViewpager(it) }
    }

    /**
     * Function to initialize toolbar
     */
    private fun initToolbar(companyName: String?) {
        companyName?.let { toolbar.title = it }
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    /**
     * Function to initialize view pager
     */
    private fun initViewpager(projects: List<ProjectUi>) {
        val adapter = ProjectAdapter(supportFragmentManager, projects)
        vpProjects.adapter = adapter
    }
}
