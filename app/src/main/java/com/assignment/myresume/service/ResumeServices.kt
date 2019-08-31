package com.assignment.myresume.service

import com.assignment.myresume.home.domain.Resume
import io.reactivex.Flowable
import retrofit2.http.GET

interface ResumeService {
    @GET("129a3b70d118dfeee857476e7103009a/raw/78836d6845741cd3c8b8608009dc1dead44e0ea7/resume")
    fun getResume(): Flowable<Resume>
}
interface ResumeService {
    @GET("129a3b70d118dfeee857476e7103009a/raw/78836d6845741cd3c8b8608009dc1dead44e0ea7/resume")
    fun getResume(): Flowable<Resume>
}