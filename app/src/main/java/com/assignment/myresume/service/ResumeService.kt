package com.assignment.myresume.service

import com.assignment.myresume.home.domain.Resume
import io.reactivex.Flowable
import retrofit2.http.GET

interface ResumeService {
    @GET("129a3b70d118dfeee857476e7103009a/raw/4690efca5cdb530f1742dd524c541d1edf58c019/resume")
    fun getResume(): Flowable<Resume>
}