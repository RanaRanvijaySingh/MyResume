package com.assignment.myresume.homescreen

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.R
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_home.*
import kotlinx.android.synthetic.main.view_progress.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity(), CompanySelectListener {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel
    private lateinit var companiesAdapter: CompaniesAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // Dagger injection
        MyResumeApplication.appComponent.inject(this)
        // Attach view model
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(HomeViewModel::class.java)
        setContentView(R.layout.activity_home)
        // Attach all observer with view model
        viewModel.resumeUiLiveData.observe(this, resumeObserver)
        viewModel.progressLiveData.observe(this, progressObserver)
        viewModel.retryOptionLiveData.observe(this, retryObserver)
    }

    /**
     * Observer for resume data.
     */
    private val resumeObserver = Observer<ResumeUi> { resumeUi ->
        setProfile(resumeUi)
        setCompanies(resumeUi.companies)
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
        }
        companiesAdapter.setList(companies)
    }

    /**
     * Call back from companies adapter class when a company is selected.
     */
    override fun companySelected(company: CompanyUi) {

    }
}
