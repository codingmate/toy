package sypg.righthand.api

import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.client.RestTemplate
import org.springframework.web.util.UriComponentsBuilder
import java.net.URI
import java.net.http.HttpClient
import java.net.http.HttpRequest
import java.net.http.HttpResponse
import java.time.Duration

@RestController
@RequestMapping("/api/calendar")
class CalendarApiController {
    val BASE_URL = "http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService/getLunCalInfo"
    val SERVICE_KEY = "2oZgjmX5voitj34/Uianpw77PCv41zm5IQ8NDXUsDERsTAve9wzr1IDCQm7aJ2wtPMp5XH1Dy1b/3Rr0VQH0rw=="

    data class DateParam (
        val year: String?,
        val month: String?,
        val day: String?
    )
    @RequestMapping("/solarToLunar")
    fun solarToLunar(@RequestBody dateParam: DateParam): ResponseEntity<String> {
        println(dateParam)
        val client = HttpClient.newHttpClient()

        val request = HttpRequest.newBuilder()
            .uri(URI.create(BASE_URL))
            .timeout(Duration.ofMinutes(1))
            .header("Content-Type", "application/json")
            .POST(HttpRequest.BodyPublishers.ofString("""{ "serviceKey": $SERVICE_KEY, "year": ${dateParam.year}, "month": ${dateParam.month}, "day": ${dateParam.day} }"""))
            .build()

        val response = client.send(request, HttpResponse.BodyHandlers.ofString())
        println(response)
        println(response.body())
        return ResponseEntity.ok(response.body())
        /*
        UriComponentsBuilder.fromHttpUrl(BASE_URL)
            .queryParam("ServiceKey", serviceKey)
            .queryParam("solYear", dateParam.year)
            .queryParam("solMonth", dateParam.month)
            .queryParam("solDay", dateParam.day)
            .queryParam("numOfRows", "10")
            .queryParam("pageNo", "1")
            .queryParam("_type", "json")
            .build()
            .toUriString()
            .also { println(it) }
            .let { RestTemplate().getForEntity(it, String::class.java) }
            .also { println(it) }
            .body
            .also { println(it) }


        return "{\"date\": \"2023-07-03\",\n" +
                "  \"lunarDate\": \"2023-05-15\",\n" +
                "  \"lunarDateName\": \"음력 5월 15일\",\n" +
                "  \"lunarYear\": 2023,\n" +
                "  \"lunarMonth\": 5,\n" +
                "  \"lunarDay\": 15,\n" +
                "  \"leapMonth\": \"false\",\n" +
                "  \"solarTerm\": \"소서\",\n" +
                "  \"solarTermDate\": \"2023-07-07\"\n" +
                "}"
         */
    }


}