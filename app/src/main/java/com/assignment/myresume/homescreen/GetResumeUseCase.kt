package com.assignment.myresume.homescreen

import com.assignment.myresume.base.UseCase
import com.assignment.myresume.rx.IoThreadScheduler
import com.assignment.myresume.rx.MainThreadScheduler
import com.assignment.myresume.rx.SchedulerProvider
import io.reactivex.Flowable
import javax.inject.Inject

/**
 * Class to use Resume repo to fetch the requested data.
 */
class GetResumeUseCase @Inject constructor(
    private val resumeRepository: ResumeRepository,
    private val mapper: Mapper,
    @IoThreadScheduler subscribeOnScheduler: SchedulerProvider,
    @MainThreadScheduler observeOnScheduler: SchedulerProvider
) : UseCase<Unit?, ResumeUi>(subscribeOnScheduler, observeOnScheduler) {

    override fun createObservable(request: Unit?): Flowable<ResumeUi> {
        // Call the service
        val flowableResume = resumeRepository.getResume()
        // Return the UI model
        return flowableResume.map { resume ->
            // Map the result from API model to UI model
            mapper.map(resume = resume)
        }
    }
}
