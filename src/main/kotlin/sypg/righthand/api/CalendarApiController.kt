package sypg.righthand.api

import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.util.UriComponentsBuilder

@RestController
@RequestMapping("/api/calendar")
class CalendarApiController {

    @GetMapping("/solarToLunar")
    fun solarToLunar(): String {
        UriComponentsBuilder.fromHttpUrl("http://apis.data.go.kr/B090041/openapi/service/LrsrCldInfoService/getLunCalInfo")
            .queryParam("ServiceKey", "2oZgjmX5voitj34/Uianpw77PCv41zm5IQ8NDXUsDERsTAve9wzr1IDCQm7aJ2wtPMp5XH1Dy1b/3Rr0VQH0rw==")
            .queryParam("solYear", "1963")
            .queryParam("solMonth", "02")
            .queryParam("solDay", "11")
            .queryParam("numOfRows", "10")
            .queryParam("pageNo", "1")
            .queryParam("_type", "json")
            .build()
            .toUriString()
            .also { println(it) }
            /*
            .let { RestTemplate().getForEntity(it, String::class.java) }
            .also { println(it) }
            .body
            .also { println(it) }

             */
        return "Hello, World!"
    }

}