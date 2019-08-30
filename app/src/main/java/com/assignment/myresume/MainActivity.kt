package com.assignment.myresume

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection

import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        AndroidInjection.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
    }
}

//https://gist.githubusercontent.com/RanaRanvijaySingh/129a3b70d118dfeee857476e7103009a/raw/4690efca5cdb530f1742dd524c541d1edf58c019/resume