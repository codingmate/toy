package sypg.righthand.learning

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDateTime
import java.time.Month
import java.time.format.DateTimeFormatter

class LocalDateTimeTest {

    @Test
    fun testLocalDateTime() {
        // 현재 날짜 및 시간 생성
        val now = LocalDateTime.now()
        assertEquals(LocalDateTime.now().year, now.year)
        assertEquals(LocalDateTime.now().month, now.month)
        assertEquals(LocalDateTime.now().dayOfMonth, now.dayOfMonth)
        assertEquals(LocalDateTime.now().hour, now.hour)
        assertEquals(LocalDateTime.now().minute, now.minute)

        // 특정 날짜 및 시간 생성
        val specificDateTime = LocalDateTime.of(2023, Month.JUNE, 28, 12, 34)
        assertEquals(2023, specificDateTime.year)
        assertEquals(Month.JUNE, specificDateTime.month)
        assertEquals(28, specificDateTime.dayOfMonth)
        assertEquals(12, specificDateTime.hour)
        assertEquals(34, specificDateTime.minute)

        // 날짜 및 시간 조작
        val tomorrow = now.plusDays(1)
        assertEquals(LocalDateTime.now().plusDays(1).dayOfMonth, tomorrow.dayOfMonth)

        val nextMonth = now.plusMonths(1)
        assertEquals(LocalDateTime.now().plusMonths(1).month, nextMonth.month)

        // 날짜 및 시간 비교
        val isBefore = now.isBefore(tomorrow)
        assertEquals(true, isBefore)

        val isAfter = tomorrow.isAfter(now)
        assertEquals(true, isAfter)

        val isEqual = now.isEqual(LocalDateTime.now())
        assertEquals(false, isEqual)
    }

    @Test
    fun testLocalDateTimeToString() {
        val dateTime = LocalDateTime.of(2023, 6, 28, 22, 12, 59, 999000000)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss.SSS")
        val formattedDateTime = dateTime.format(formatter)
        assertEquals("2023-06-28 22:12:59.999", formattedDateTime)
    }
}
