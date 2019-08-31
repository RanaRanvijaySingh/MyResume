package com.assignment.myresume.homescreen

import com.assignment.myresume.base.UseCase
import com.assignment.myresume.rx.IoThreadScheduler
import com.assignment.myresume.rx.MainThreadScheduler
import com.assignment.myresume.rx.SchedulerProvider
import io.reactivex.Flowable
import javax.inject.Inject

class GetResumeUseCase @Inject constructor(
    private val resumeRepository: ResumeRepository,
    private val mapper: Mapper,
    @IoThreadScheduler subscribeOnScheduler: SchedulerProvider,
    @MainThreadScheduler observeOnScheduler: SchedulerProvider
) : UseCase<Unit?, ResumeUi>(subscribeOnScheduler, observeOnScheduler) {

    override fun createObservable(request: Unit?): Flowable<ResumeUi> {
        val flowableResume = resumeRepository.getResume()
        return flowableResume.map { resume ->
            mapper.map(resume = resume)
        }
    }
}
