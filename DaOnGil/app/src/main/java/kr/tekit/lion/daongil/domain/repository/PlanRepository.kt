package kr.tekit.lion.daongil.domain.repository

import kr.tekit.lion.daongil.data.datasource.PlanDataSource
import kr.tekit.lion.daongil.data.network.RetrofitInstance
import kr.tekit.lion.daongil.data.network.service.PlanService
import kr.tekit.lion.daongil.data.repository.PlanRepositoryImpl
import kr.tekit.lion.daongil.domain.model.BriefScheduleInfo
import kr.tekit.lion.daongil.domain.model.MyMainSchedule
import kr.tekit.lion.daongil.domain.model.NewPlan
import kr.tekit.lion.daongil.domain.model.NewScheduleReview
import kr.tekit.lion.daongil.domain.model.OpenPlan
import kr.tekit.lion.daongil.domain.model.PlaceSearchResult
import kr.tekit.lion.daongil.domain.model.ReviewImg
import kr.tekit.lion.daongil.domain.model.ScheduleDetail

interface PlanRepository {
    suspend fun getOpenPlanList(size: Int, page: Int): OpenPlan

    suspend fun addNewPlan(request: NewPlan)

    // 구현해야 할 메서드
    suspend fun getPlaceSearchResult(word: String, page: Int, size: Int) : PlaceSearchResult

    suspend fun getMyMainSchedule(): List<MyMainSchedule?>?

    suspend fun getBriefScheduleInfo(planId: Long) : BriefScheduleInfo

    suspend fun addNewScheduleReview(
        planId: Long,
        scheduleReview: NewScheduleReview,
        images: List<ReviewImg>
    )

    suspend fun getDetailScheduleInfo(planId: Long): ScheduleDetail

    suspend fun getDetailScheduleInfoGuest(plandId: Long): ScheduleDetail

    companion object{
        fun create(): PlanRepositoryImpl{
            return PlanRepositoryImpl(
                PlanDataSource(
                    RetrofitInstance.serviceProvider(PlanService::class.java)
                )
            )
        }
    }
}