package com.assignment.myresume.homescreen.companyscreen

import com.assignment.myresume.base.UseCase
import com.assignment.myresume.rx.IoThreadScheduler
import com.assignment.myresume.rx.MainThreadScheduler
import com.assignment.myresume.rx.SchedulerProvider
import com.assignment.myresume.utils.Constants
import io.reactivex.Flowable
import javax.inject.Inject

class GetCompanyUseCase @Inject constructor(
    private val respository: CompanyRepository,
    private val mapper: Mapper,
    @IoThreadScheduler subscribeOnScheduler: SchedulerProvider,
    @MainThreadScheduler observeOnScheduler: SchedulerProvider
) : UseCase<String?, CompanyDetailUi>(subscribeOnScheduler, observeOnScheduler) {

    override fun createObservable(request: String?): Flowable<CompanyDetailUi> {
        if (request == null) {
            return Flowable.error(Exception(Constants.INVALID_REQUEST))
        }
        val flowableResponse = respository.getCompany(request)
        return flowableResponse.map { company ->
            mapper.map(company)
        }
    }
}
