package kr.tekit.lion.daongil.domain.usecase

import kr.tekit.lion.daongil.domain.model.EmergencyBasicInfo
import kr.tekit.lion.daongil.domain.model.EmergencyMapInfo
import kr.tekit.lion.daongil.domain.model.EmergencyRealtimeInfo
import kr.tekit.lion.daongil.domain.repository.EmergencyRepository
import kr.tekit.lion.daongil.domain.usecase.base.BaseUseCase
import kr.tekit.lion.daongil.domain.usecase.base.Result

class GetEmergencyMapInfoUseCase(
    private val emergencyRepository: EmergencyRepository
) : BaseUseCase() {
    suspend operator fun invoke(STAGE1: String?, STAGE2: String?): Result<List<EmergencyMapInfo>> =
        execute {
            val emergencyRealtimeList = emergencyRepository.getEmergencyRealtime(STAGE1, STAGE2)
            val emergencyMapInfoList = emergencyRealtimeList.map {
                val emergencyBasicInfo = emergencyRepository.getEmergencyBasic(it.hospitalId)
                setEmergencyMapInfo(it, emergencyBasicInfo)
            }
            emergencyMapInfoList
        }


    private fun setEmergencyMapInfo(
        realtimeInfo: EmergencyRealtimeInfo,
        basicInfo: EmergencyBasicInfo
    ): EmergencyMapInfo{
        return EmergencyMapInfo(
            hospitalId = realtimeInfo.hospitalId,
            emergencyCount = realtimeInfo.emergencyCount,
            emergencyKid = realtimeInfo.emergencyKid,
            emergencyKidCount = realtimeInfo.emergencyKidCount,
            emergencyAllCount = realtimeInfo.emergencyAllCount,
            emergencyKidAllCount = realtimeInfo.emergencyKidAllCount,
            emergencyBed = realtimeInfo.emergencyCount?.let { count ->
                realtimeInfo.emergencyAllCount?.let { allCount ->
                    ((count.toFloat() / allCount) * 100).toInt()
                }
            },
            emergencyKidBed =  realtimeInfo.emergencyKidCount?.let { kidCount ->
                realtimeInfo.emergencyKidAllCount?.let { kidAllCount ->
                    ((kidCount.toFloat() / kidAllCount) * 100).toInt()
                }
            },
            lastUpdateDate = realtimeInfo.lastUpdateDate,
            hospitalName = basicInfo.hospitalName,
            hospitalAddress = basicInfo.hospitalAddress,
            hospitalTel = basicInfo.hospitalTel,
            emergencyTel = basicInfo.emergencyTel,
            dialysis = basicInfo.dialysis,
            earlyBirth = basicInfo.earlyBirth,
            burns = basicInfo.burns,
            hospitalLon = basicInfo.hospitalLon,
            hospitalLat = basicInfo.hospitalLat
        )
    }
}