package kr.tekit.lion.daongil.data.dto.remote.base

class ApiConstants {
    companion object{
        const val API_CODES_MAX_NUM_OF_ROWS = "31"
        const val API_RESULT_MAX_NUM_OF_ROWS = "10000"
        const val API_MOBILE_OS = "AND"
        const val API_TYPE = "json"
        const val APP_NAME = "DaOnGil"
        const val SERVICE_KEY = "t2ivQakqcZ/cvxzekT7Ra9Ja8J1N1lBKu6LqVkijMliEeoD1lLXU0Qei+V9AC8aMbNG+TjVkca70NqFB9akmSg=="
        const val API_LIST_YN = "Y"
        const val API_ARRANGE = "O"

        val areaBasedSearchRequest: Map<String, String> =
            mapOf(
                "numOfRows" to API_RESULT_MAX_NUM_OF_ROWS,
                "MobileOS" to API_MOBILE_OS,
                "MobileApp" to APP_NAME,
                "_type" to API_TYPE,
                "serviceKey" to SERVICE_KEY,
                "listYN" to API_LIST_YN,
                "arrange" to API_ARRANGE,
            )
    }
}