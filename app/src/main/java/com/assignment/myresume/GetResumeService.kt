package com.assignment.myresume

import retrofit2.Call
import retrofit2.http.GET

interface GetResumeService {
    @GET("129a3b70d118dfeee857476e7103009a/raw/4690efca5cdb530f1742dd524c541d1edf58c019/resume")
    fun getResume(): Call<Resume>
}