package com.assignment.myresume.service

import com.assignment.myresume.homescreen.Resume
import io.reactivex.Flowable
import retrofit2.http.GET

interface ResumeService {

    @GET("129a3b70d118dfeee857476e7103009a/raw/78836d6845741cd3c8b8608009dc1dead44e0ea7/resume")
    fun getResume(): Flowable<Resume>

    @GET("3135f39381f13b2004ea7a215938cd48/raw/51b69f3385e77a7a23767f1848c49afee506269c/theleanapps")
    fun getProject(): Flowable<Resume>
}