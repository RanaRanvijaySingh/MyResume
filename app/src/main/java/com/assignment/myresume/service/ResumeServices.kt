package com.assignment.myresume.service

import com.assignment.myresume.homescreen.Resume
import com.assignment.myresume.homescreen.companiesscreen.CompanyDetail
import io.reactivex.Flowable
import retrofit2.http.GET
import retrofit2.http.Path

interface ResumeService {

    @GET("129a3b70d118dfeee857476e7103009a/raw/78836d6845741cd3c8b8608009dc1dead44e0ea7/resume")
    fun getResume(): Flowable<Resume>

    @GET("{url}")
    fun getCompany(@Path("url") url: String): Flowable<CompanyDetail>
}


//https://gist.githubusercontent.com/RanaRanvijaySingh/61c8fd78ac370da3050afa8bab06f688/raw/7edf75b1a9f7a43e2b629079ed8cdcd14b3d73f5/webonise

//https://gist.githubusercontent.com/RanaRanvijaySingh/3135f39381f13b2004ea7a215938cd48/raw/51b69f3385e77a7a23767f1848c49afee506269c/theleanapps

//https://gist.githubusercontent.com/RanaRanvijaySingh/b03778260d79c4f0d9c31776a3b7d3f8/raw/b802f11336617452c9905408f130adc7ab2ade85/globant