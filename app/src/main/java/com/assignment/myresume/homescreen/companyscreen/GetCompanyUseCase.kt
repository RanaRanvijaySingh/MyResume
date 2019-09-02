package com.assignment.myresume.homescreen.companyscreen

import com.assignment.myresume.base.UseCase
import com.assignment.myresume.rx.IoThreadScheduler
import com.assignment.myresume.rx.MainThreadScheduler
import com.assignment.myresume.rx.SchedulerProvider
import com.assignment.myresume.utils.Constants
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Class to use Resume repo to fetch the requested data.
 */
class GetCompanyUseCase @Inject constructor(
    private val respository: CompanyRepository,
    private val mapper: Mapper,
    @IoThreadScheduler subscribeOnScheduler: SchedulerProvider,
    @MainThreadScheduler observeOnScheduler: SchedulerProvider
) : UseCase<String?, CompanyDetailUi>(subscribeOnScheduler, observeOnScheduler) {

    override fun createObservable(request: String?): Flowable<CompanyDetailUi> {
        // Check if the request is valid or not
        if (request == null) {
            // Return error wrapped in flowable in case of error.
            return Flowable.error(Exception(Constants.INVALID_REQUEST))
        }
        // Call the service
        val flowableResponse = respository.getCompany(request)
        // Return the UI model
        return flowableResponse.map { company ->
            // Map the result from API model to UI model
            mapper.map(company)
        }
    }
}
