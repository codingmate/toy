package sypg.righthand.client.openapi

// 음양력 정보제공 서비스
class LrsrCldInfoServiceClient(
    val serviceUrl: String = "http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService"
) {
    data class RequestParam(
        val solYear: String,
        val solMonth: String,
        val solDay: String?
    )

    data class Response(
        val resultCode: String,
        val resultMag: String,
        val items: List<Item>,
        val numOfRows: String?,
        val pageNo: String?,
        val totalCount: String?
    )

    data class Item(
        val lunMonth: String,
        val lunDay: String,
        val solDay: String,
        val solLeapyear: String,
        val lunLeapmonth: String,
        val solWeek: String,
        val lunWolgeon: String,
        val lunNday: String,
        val lunYear: String,
        val solYear: String,
        val solMonth: String,
        val lunSecha: String,
        val lunIljin: String,
        val solJd: String
    )
}