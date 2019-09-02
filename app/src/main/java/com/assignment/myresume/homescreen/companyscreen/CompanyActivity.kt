package com.assignment.myresume.homescreen.companyscreen

import android.content.Intent
import android.os.Bundle
import android.os.Parcelable
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.R
import com.assignment.myresume.homescreen.companyscreen.projectsscreen.ProjectsActivity
import com.assignment.myresume.utils.Constants
import com.bumptech.glide.Glide
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_company.*
import javax.inject.Inject

class CompanyActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: CompanyViewModel
    private var companyDataUrl: String? = null
    private var companyDetailUi: CompanyDetailUi? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // Dagger injection
        MyResumeApplication.appComponent.inject(this)
        setContentView(R.layout.activity_company)
        // Attach view model
        viewModel = ViewModelProviders.of(this, viewModelFactory)
            .get(CompanyViewModel::class.java)

        // Get company detail data url from intent
        companyDataUrl = intent.getStringExtra(Constants.IntentKeys.COMPANY_DETAIL_URL)
        val companyName = intent.getStringExtra(Constants.IntentKeys.COMPANY_NAME)

        initToolbar(companyName)
        // Attach all observer with view model
        viewModel.companyDetailLiveData.observe(this, companyDetailObserver)
        viewModel.progressLiveData.observe(this, progressObserver)
        viewModel.retryOptionLiveData.observe(this, retryObserver)

        // Initiate call for company detail
        companyDataUrl?.let { viewModel.getCompanyDetail(it) }
    }

    private fun initToolbar(companyName: String?) {
        companyName?.let { toolbar.title = it }
        setSupportActionBar(toolbar)
        toolbar.setNavigationOnClickListener {
            finish()
        }
    }

    /**
     * Observer for company detail.
     */
    private val companyDetailObserver = Observer<CompanyDetailUi> { companyDetailUi ->
        this.companyDetailUi = companyDetailUi
        setLogo(companyDetailUi.logo)
        tvName.text = companyDetailUi.name
        tvDesignation.text = companyDetailUi.designations
        tvRole.text = companyDetailUi.role
        tvStartDate.text = companyDetailUi.startDate
        tvEndDate.text = companyDetailUi.endDate
        tvDuration.text = companyDetailUi.duration
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
            companyDataUrl?.let { viewModel.getCompanyDetail(it) }
        }.show()
    }

    /**
     * Function to set the profile image
     */
    private fun setLogo(imageUrl: String) {
        Glide.with(this)
            .load(imageUrl)
            .centerInside()
            .into(ivLogo)
    }

    fun onClickProjects(view: View) {
        companyDetailUi?.let {
            val intent = Intent(this, ProjectsActivity::class.java)
            val bundle = Bundle()
            bundle.putParcelableArrayList(Constants.IntentKeys.PROJECTS, it.projects as ArrayList<out Parcelable>)
            bundle.putString(Constants.IntentKeys.COMPANY_NAME, it.name)
            intent.putExtras(bundle)
            startActivity(intent)
        }
    }
}
