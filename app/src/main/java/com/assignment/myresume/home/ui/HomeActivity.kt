package com.assignment.myresume.home.ui

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.assignment.myresume.MyResumeApplication
import com.assignment.myresume.R
import com.assignment.myresume.home.domain.ResumeUi
import com.google.android.material.snackbar.Snackbar
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.view_progress.*
import javax.inject.Inject

class HomeActivity : AppCompatActivity() {

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: HomeViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyResumeApplication.appComponent.inject(this)
        viewModel = ViewModelProviders.of(this, viewModelFactory).get(HomeViewModel::class.java)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        viewModel.resumeUiLiveData.observe(this, resumeObserver)
        viewModel.progressLiveData.observe(this, progressObserver)
        viewModel.retryOptionLiveData.observe(this, retryObserver)
    }

    private val resumeObserver = Observer<ResumeUi> { resumeUi ->
        tvResponse.text = resumeUi.toString()
    }

    private val progressObserver = Observer<Boolean> { isProgressBarVisible ->
        rlProgress.visibility = if (isProgressBarVisible) View.VISIBLE else View.GONE
    }

    private val retryObserver = Observer<String> { message ->
        Snackbar.make(
            findViewById(android.R.id.content),
            message,
            Snackbar.LENGTH_INDEFINITE
        ).setAction(resources.getString(R.string.retry)) {
            viewModel.getResume()
        }.show()
    }
}
