package com.assignment.myresume

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity;
import dagger.android.AndroidInjection
import io.reactivex.Observable
import io.reactivex.SingleEmitter
import io.reactivex.SingleObserver

import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var retrofit: Retrofit

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyResumeApplication.appComponent.inject(this)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)
        testRetrofit()
    }

    fun testRetrofit() {
        val service = retrofit.create(GetResumeService::class.java)
        val call = service.getResume()
        call.enqueue(callback)
    }

    private val callback = object : Callback<Resume> {
        override fun onFailure(call: Call<Resume>, t: Throwable) {
            Log.i(">>>", "onFailure")
        }

        override fun onResponse(call: Call<Resume>, response: Response<Resume>) {
            Log.i(">>>", "onResponse")
            if (response.isSuccessful) {
                Log.i(">>>", "SUCCESS")
            } else {
                Log.i(">>>", "FAILURE")
            }
        }
    }
}
