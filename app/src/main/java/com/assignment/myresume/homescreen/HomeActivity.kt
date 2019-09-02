package com.assignment.myresume.homescreen

import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.test.espresso.idling.CountingIdlingResource
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.R
import com.assignment.myresume.homescreen.companyscreen.CompanyActivity
import com.assignment.myresume.utils.Constants
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_carrier_summary.*
import kotlinx.android.synthetic.main.view_profile.*
import kotlinx.android.synthetic.main.view_qualifications_summary.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), CompanySelectListener {

    val idleResource = CountingIdlingResource(HomeActivity::class.java.simpleName)

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel
    private lateinit var companiesAdapter: CompaniesAdapter
    private lateinit var skillsAdapter: SkillsAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dagger injection
        MyResumeApplication.appComponent.inject(this)
        setContentView(R.layout.activity_home)
        idleResource.increment()
        // Attach view model
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(HomeViewModel::class.java)

        // Attach all observer with view model
        viewModel.resumeUiLiveData.observe(this, resumeObserver)
        viewModel.progressLiveData.observe(this, progressObserver)
        viewModel.retryOptionLiveData.observe(this, retryObserver)
    }

    /**
     * Observer for resume data.
     */
    private val resumeObserver = Observer<ResumeUi> { resumeUi ->
        idleResource.decrement()
        setProfile(resumeUi)
        setCompanies(resumeUi.companies)
        setSkills(resumeUi.skillSummary)
        tvCareerSummary.text = resumeUi.careerSummary
        tvProjectManagementTools.text = resumeUi.projectManagementTools
        tvTestingTools.text = resumeUi.unitUiTestTools
        tvDatabases.text = resumeUi.databases
        tvOs.text = resumeUi.operatingSystem
        tvProgrammingLanguage.text = resumeUi.programmingLanguages
        tvScmTool.text = resumeUi.scmTool
        tvApiTool.text = resumeUi.apiTool
        tvDevopsTool.text = resumeUi.devopsTools
        tvLanguages.text = resumeUi.languages
    }

    /**
     * Observer for progress bar. To show if the api call is ongoing or completed.
     */
    private val progressObserver = Observer<Boolean> { isProgressBarVisible ->
        rlProgress?.let {
            it.visibility = if (isProgressBarVisible) View.VISIBLE else View.GONE
        }
    }

    /**
     * Observer for network connection and failed api response.
     */
    private val retryObserver = Observer<String> { message ->
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_INDEFINITE
        ).setAction(resources.getString(R.string.retry)) {
            viewModel.getResume()
        }.show()
    }

    /**
     * Function to set the user profile
     */
    private fun setProfile(resumeUi: ResumeUi) {
        tvName.text = resumeUi.user
        setProfileImage(resumeUi.image)
    }

    /**
     * Function to set the profile image
     */
    private fun setProfileImage(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .centerCrop()
            .into(ivProfile)
    }

    /**
     * Function to set companies list
     */
    private fun setCompanies(companies: List<CompanyUi>) {
        companiesAdapter = CompaniesAdapter(this)
        val layoutManager = LinearLayoutManager(this)
        layoutManager.orientation = RecyclerView.VERTICAL
        rvCompanies.apply {
            setHasFixedSize(true)
            setLayoutManager(layoutManager)
            adapter = companiesAdapter
            isNestedScrollingEnabled = false
        }
        companiesAdapter.setList(companies)
    }

    /**
     * Function to set skill list
     */
    private fun setSkills(skills: List<String>) {
        skillsAdapter = SkillsAdapter()
        val layoutManager = GridLayoutManager(this, 3)
        rvSkills.apply {
            setHasFixedSize(true)
            setLayoutManager(layoutManager)
            adapter = skillsAdapter
            isNestedScrollingEnabled = false
        }
        skillsAdapter.setList(skills)
    }

    /**
     * Call back from companies adapter class when a company is selected.
     */
    override fun companySelected(company: CompanyUi) {
        val intent = Intent(this, CompanyActivity::class.java)
        intent.putExtra(Constants.IntentKeys.COMPANY_DETAIL_URL, company.data)
        intent.putExtra(Constants.IntentKeys.COMPANY_NAME, company.name)
        startActivity(intent)
    }
}
