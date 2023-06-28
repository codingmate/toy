package sypg.righthand.learning

import org.junit.jupiter.api.Assertions.assertEquals
import org.junit.jupiter.api.Test
import java.time.LocalDate
import java.time.Month
import java.time.format.DateTimeFormatter

class LocalDateTest {

    @Test
    fun testLocalDate() {
        // 오늘 날짜 생성
        val today = LocalDate.now()
        assertEquals(LocalDate.now(), today)

        // 특정 날짜 생성
        val specificDate = LocalDate.of(2023, Month.JUNE, 28)
        assertEquals(2023, specificDate.year)
        assertEquals(Month.JUNE, specificDate.month)
        assertEquals(28, specificDate.dayOfMonth)

        // 날짜 조작
        val tomorrow = today.plusDays(1)
        assertEquals(LocalDate.now().plusDays(1), tomorrow)

        val nextMonth = today.plusMonths(1)
        assertEquals(LocalDate.now().plusMonths(1), nextMonth)

        // 날짜 비교
        val isBefore = today.isBefore(tomorrow)
        assertEquals(true, isBefore)

        val isAfter = tomorrow.isAfter(today)
        assertEquals(true, isAfter)

        val isEqual = today.isEqual(LocalDate.now())
        assertEquals(true, isEqual)
    }

    @Test
    fun testLocalDateToString() {
        val date = LocalDate.of(2023, 6, 28)
        val formatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")
        val formattedDate = date.format(formatter)
        assertEquals("2023-06-28", formattedDate)
    }
}
